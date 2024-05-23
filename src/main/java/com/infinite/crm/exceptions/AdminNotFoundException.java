package com.infinite.crm.exceptions;

public class AdminNotFoundException extends RuntimeException{
	public AdminNotFoundException(String message) {
		super("couldn't find the admin"+ message);
	}

}
