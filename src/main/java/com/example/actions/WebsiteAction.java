//$Id$
package com.example.actions;

import com.example.process.DatabaseManager;
import com.opensymphony.xwork2.ActionSupport;

public class WebsiteAction extends ActionSupport {

	public String execute() 
    {
		System.out.println("Website - Success");
        return SUCCESS;
    }
}
