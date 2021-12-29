package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOManager {
	private static final String errorMessage = "Đã có lỗi xảy ra";
	private static final String fileNotFoundErrorMessage = "Lỗi không tìm thấy file";
	private static final String classNotFoundErrorMessage = "Lỗi không tìm thấy class";
	private static final String IOErrorMessage = "Lỗi đóng mở file";
	
	public static String readFile(String pathFile) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(pathFile);
			byte[] byteInput = fileInputStream.readAllBytes();
			return new String(byteInput, 0, byteInput.length);
		} catch (FileNotFoundException e) {
			System.out.println(fileNotFoundErrorMessage);
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			System.out.println(IOErrorMessage);
			e.printStackTrace();
			return "";
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				System.out.println(IOErrorMessage);
				e.printStackTrace();
			}
		}
		
	}
	
	public static void writeFile(String pathFile, boolean isContinuing, String content) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(pathFile, isContinuing);
			fileOutputStream.write(content.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println(fileNotFoundErrorMessage);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IOErrorMessage);
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				System.out.println(IOErrorMessage);
				e.printStackTrace();
			}
		}
	}
	
	public static Object readObjectFile(String pathFile) {
		Object obj = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(pathFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			obj = objectInputStream.readObject();
			fileInputStream.close();
			objectInputStream.close();
		} catch (ClassNotFoundException e) {
			System.out.println(classNotFoundErrorMessage);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IOErrorMessage);
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void writeObjectFile(String pathFile, Object obj) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(pathFile, false);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(obj);
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(classNotFoundErrorMessage);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IOErrorMessage);
			e.printStackTrace();
		}
	}
}
