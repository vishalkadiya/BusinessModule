package com.multiVendor.commonUtils;

public class Exceptions {

	@SuppressWarnings("serial")
	class UserDefineException extends Exception{
		String message;
	    UserDefineException(String errorMessage){
	    	message = errorMessage;
	    }
	    public String toString(){
	        return (message) ;
	    }
	}
}
