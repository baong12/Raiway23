package com.vti.utils;

import java.util.Date;

import com.vti.entity.MyException;

public class LogUtils {
	public static void writeLog(String message, String reason, StackTraceElement[] stackTrace, Date time) {
		MyException exception = new MyException(message, new Throwable(reason), stackTrace, time);
		IOManager.writeFile("log.txt", true, exception.format());
	}

	public static void writeLog(MyException exception) {
		IOManager.writeFile("log.txt", true, exception.format());
	}
}
