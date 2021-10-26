package com.example.exam.model.binding;

import com.example.exam.model.validator.UniqueUserName;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters")
    @UniqueUserName
    private String username;
    @Size(min = 5, max = 20, message = "Full name length must be between 5 and 20 characters")
    private String fullName;
    @Size(min = 3, message = "Password length must more than 3 characters")
    private String password;
    @Size(min = 3, message = "Password length must more than 3 characters")
    private String confirmPassword;
    @Email(message = "Enter valid email format")
    @NotBlank(message = "email cann not be empty")
    private String email;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
