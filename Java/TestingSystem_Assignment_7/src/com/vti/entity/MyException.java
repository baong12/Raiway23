package com.vti.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyException extends Exception {
	private String message;
	private Throwable reason;
	private StackTraceElement[] stackTrace;
	private Date time;

	/**
	 * @param message
	 * @param reason
	 * @param stackTrace
	 * @param time 
	 */
	public MyException(String message, Throwable reason, StackTraceElement[] stackTrace, Date time) {
		super();
		this.message = message;
		this.reason = reason;
		this.stackTrace = stackTrace;
		this.time = time;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	
	public String format() {
		String stackTraceString = "\n";
		for (StackTraceElement stackTraceElement : stackTrace) {
			stackTraceString += "\t" + stackTraceElement + "\n";
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		String dateTime = dateFormat.format(time.getTime());
		return dateTime + ":\n"
				+ "Message: " + message + "\n"
				+ "Reason: " + reason + "\n"
				+ "StackTrace: " + stackTraceString
				+ "\n";
	}
}
