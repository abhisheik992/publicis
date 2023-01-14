package com.publicis.poc.errorhandler;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessaage {

	 // customizing timestamp serialization format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;



	public ErrorMessaage() {
		super();
	}


	public ErrorMessaage(Date timestamp, int code, String status, String message, String stackTrace) {
		super();
		this.timestamp = timestamp;
		this.code = code;
		this.status = status;
		this.message = message;
		this.stackTrace = stackTrace;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStackTrace() {
		return stackTrace;
	}


	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}


}
