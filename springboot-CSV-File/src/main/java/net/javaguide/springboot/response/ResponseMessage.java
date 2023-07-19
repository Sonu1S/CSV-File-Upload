package net.javaguide.springboot.response;

public class ResponseMessage {
    private String message;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
