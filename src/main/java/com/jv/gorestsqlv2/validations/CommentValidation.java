package com.jv.gorestsqlv2.validations;

import com.jv.gorestsqlv2.models.Comment;
import com.jv.gorestsqlv2.models.Post;
import com.jv.gorestsqlv2.models.Todo;
import com.jv.gorestsqlv2.models.User;
import com.jv.gorestsqlv2.repositories.CommentRepository;
import com.jv.gorestsqlv2.repositories.PostRepository;
import com.jv.gorestsqlv2.repositories.TodoRepository;
import com.jv.gorestsqlv2.repositories.UserRepository;

import java.util.Optional;

public class CommentValidation {

    public static ValidationError validateComment(Comment comment, CommentRepository commentRepo, PostRepository postRepo, boolean isUpdate) {
        ValidationError errors = new ValidationError();

        if(isUpdate) {
            if (comment.getId() == 0) {
                errors.addError("id", "ID can not be left blank");
            }
            else{
                Optional<Comment> foundUser = commentRepo.findById(comment.getId());
                if(foundUser.isEmpty()) {
                    errors.addError("id", "No todo found with the ID: " + comment.getId());
                }
            }
        }

        String commentName = comment.getName();
        long postId = comment.getPost_id();
        String commentEmail = comment.getEmail();
        String commentBody = comment.getBody();

        if (commentName == null || commentName.trim().equals("")) {
            errors.addError("name", "Name can not be left blank");
        }

        if (commentEmail == null || commentEmail.trim().equals("")) {
            errors.addError("email", "Email can not be left blank");
        }

        if (commentBody == null || commentBody.trim().equals("")) {
            errors.addError("body", "Body can not be left blank");
        }

        if (postId == 0) {
            errors.addError("post_id", "Post ID can not be left blank");
        }
        else {
            Optional<Post> foundPost = postRepo.findById(postId);

            if(foundPost.isEmpty()) {
                errors.addError("post_id", "Post_ID is invalid because there is no post found with the id: " + postId);
            }

        }
        return errors;
    }
}
