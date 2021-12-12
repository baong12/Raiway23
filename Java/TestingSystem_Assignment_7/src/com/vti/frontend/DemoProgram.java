package com.vti.frontend;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DemoProgram {
	public static void main(String[] args) {
//		readFileByte();
		copyFileCharacter();
	}
	
	private static void copyFileCharacter() {
		FileReader in = null;
		FileWriter out = null;
		int c;
		
		try {
			in = new FileReader("C:\\Users\\baong\\Desktop\\test.txt");
			out = new FileWriter("C:\\Users\\baong\\Desktop\\output.txt");
			int i = 0;
			while ((c = in.read()) != -1) {
				i++;
				out.write(c);
			}
			System.out.println("Số lần đọc:" + i);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			if (out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFileByte() {
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\baong\\Desktop\\japanese.txt");
			byte[] b = new byte[1024];
			int length;
			while ((length = fileInputStream.read(b)) > -1) {
				System.out.println(length);
				String content = new String(b, 0, length);
				System.out.println(content);
				System.out.println("------------------");
			}
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
