package com.goeuro.testdev.exception;

public class GoeuroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5641647514369321462L;
	
	private String errorCode="Unknown_Exception";
	
	public GoeuroException(String message, String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
     
    public String getErrorCode(){
        return this.errorCode;
    }

}
