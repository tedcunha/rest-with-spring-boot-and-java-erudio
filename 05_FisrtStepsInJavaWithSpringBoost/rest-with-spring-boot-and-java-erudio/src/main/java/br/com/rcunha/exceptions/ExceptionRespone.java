package br.com.rcunha.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionRespone implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String message;
	private String detais;
	
	public ExceptionRespone(Date timestamp, String message, String detais) {
		this.timestamp = timestamp;
		this.message = message;
		this.detais = detais;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetais() {
		return detais;
	}

	public void setDetais(String detais) {
		this.detais = detais;
	}
	
	
}
