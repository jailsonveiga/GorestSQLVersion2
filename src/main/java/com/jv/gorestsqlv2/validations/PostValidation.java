package com.jv.gorestsqlv2.validations;

import com.jv.gorestsqlv2.models.Post;
import com.jv.gorestsqlv2.models.User;
import com.jv.gorestsqlv2.repositories.PostRepository;
import com.jv.gorestsqlv2.repositories.UserRepository;

import java.util.Optional;

public class PostValidation {

    public static ValidationError validatePost (Post post, PostRepository postRepo, UserRepository userRepo, boolean isUpdate) {

        ValidationError errors = new ValidationError();

        if(isUpdate) {
            if (post.getId() == 0) {
                errors.addError("id", "ID can not be left blank");
            }
            else{
                Optional<Post> foundPost = postRepo.findById(post.getId());
                if(foundPost.isEmpty()) {
                    errors.addError("id", "No post found with the ID: " + post.getId());
                }
            }
        }

        String postTitle = post.getTitle();
        String postBody = post.getBody();
        long postUserId = post.getUser_id();

        if (postTitle == null || postTitle.trim().equals("")) {
            errors.addError("title", "Title can not be left blank");
        }

        if (postBody == null || postBody.trim().equals("")) {
            errors.addError("body", "Body can not be left blank");
        }

        if (postUserId == 0) {
            errors.addError("user_id", "User_ID can not be left blank");
        }
        else{
            Optional<User> foundUser = userRepo.findById(postUserId);
            if (foundUser.isEmpty()){
                errors.addError("user_id", "User_ID is invalid because there is no user found with the id: " + postUserId);
            }
        }
        return errors;
    }
}
