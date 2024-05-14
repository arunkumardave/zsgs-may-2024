package com.example.actions;

import com.example.process.DatabaseManager;
import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport {
    private String name;
	private String dob;
    private String username;
    private String password;
    private String email;

    public String execute() 
    {
        boolean success = DatabaseManager.addUser(name, dob, username, password, email);
        if (success) {
            return SUCCESS; // Redirect to success page or login page
        } else {
            return ERROR; // Redirect to signup page with error message
        }
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
