package com.example.Andrey.s.exam.model.binding;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UserRegisterBindingModel {

    @Size(min = 2)
    private String username;
    @Email
    private String email;
    @DecimalMin(value = "0")
    private BigDecimal budget;
    @Size(min = 2)
    private String password;
    @Size(min = 2)
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public UserRegisterBindingModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
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
