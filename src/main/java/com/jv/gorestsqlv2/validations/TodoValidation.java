package com.jv.gorestsqlv2.validations;

import com.jv.gorestsqlv2.models.Post;
import com.jv.gorestsqlv2.models.Todo;
import com.jv.gorestsqlv2.models.User;
import com.jv.gorestsqlv2.repositories.TodoRepository;
import com.jv.gorestsqlv2.repositories.UserRepository;

import java.util.Optional;

public class TodoValidation {

    public static ValidationError validateTodo(Todo todo, TodoRepository todoRepo, UserRepository userRepo, boolean isUpdate) {
        ValidationError errors = new ValidationError();

        if(isUpdate) {
            if (todo.getId() == 0) {
                errors.addError("id", "ID can not be left blank");
            }
            else{
                Optional<Todo> foundUser = todoRepo.findById(todo.getId());
                if(foundUser.isEmpty()) {
                    errors.addError("id", "No todo found with the ID: " + todo.getId());
                }
            }
        }

        String todoTitle = todo.getTitle();
        String todoDueOne = todo.getDue_on();
        String userStatus = todo.getStatus();
        long todoUserId = todo.getUser_id();

        if (todoTitle == null || todoTitle.trim().equals("")) {
            errors.addError("title", "Title can not be left blank");
        }

        if (todoDueOne == null || todoDueOne.trim().equals("")) {
            errors.addError("due_on", "due_on can not be left blank");
        }

        if (userStatus == null || userStatus.trim().equals("")) {
            errors.addError("status", "Status can not be left blank");
        }
        else if (!userStatus.equals("completed") || userStatus.equals("pending")){
            errors.addError("status", "Status must be: completed or pending");
        }

        if (todoUserId == 0) {
            errors.addError("user_id", "User_ID can not be left blank");
        }
        else {
            Optional<User> foundUser = userRepo.findById(todoUserId);

            if(foundUser.isEmpty()) {
                errors.addError("user_id", "User_ID is invalid because there is no user found with the id: " + todoUserId);
        }

        }
        return errors;
    }
}

