package com.example.actions;

import com.example.process.DatabaseManager;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String execute() 
    {
    	boolean success = DatabaseManager.validateUser(username, password);
        if (success) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    // Getters and setters for username and password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
