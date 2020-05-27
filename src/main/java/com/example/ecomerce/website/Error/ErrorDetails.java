package com.example.ecomerce.website.Error;

import java.sql.Date;
import java.time.LocalDateTime;

public class ErrorDetails {

	private String message;
	private String path;
	
	
	private LocalDateTime timeestamp;
	
	
	
	
	public ErrorDetails(String message, String path,LocalDateTime timeestamp) {
		this.message = message;
		this.path = path;
	
		this.timeestamp = timeestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public LocalDateTime getTimeestamp() {
		return timeestamp;
	}
	public void setTimeestamp(LocalDateTime timeestamp) {
		this.timeestamp = timeestamp;
	}
	
	
}
