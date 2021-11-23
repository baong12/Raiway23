package com.vti.academy;
import java.util.Iterator;
import java.util.Scanner;

public class Exercise4_String {
	private static Scanner scanner;
	private static Group[] groups;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		Group gr1 = new Group();
		gr1.name = "Java cơ bản";
		Group gr2 = new Group();
		gr2.name = "Java nâng cao";
		Group gr3 = new Group();
		gr3.name = "SQL";
		Group gr4 = new Group();
		gr4.name = "Full stackoverflow";
		groups = new Group[] { gr1, gr2, gr3, gr4 };
		
//		question1();
//		question2();
//		question3();
//		question4();
//		question5();
//		question6();
//		question7();
//		question8();
//		question9();
//		question10();
//		question11();
//		question12();
//		question13();
//		question14();
//		question15();
		question16();
		scanner.close();
	}
	
//	Exercise 4: String
//	Question 1:
//	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//	thể cách nhau bằng nhiều khoảng trắng );
	public static void question1() {
		System.out.println("\n-- Question 1:");
		System.out.println("Nhập vào một xâu kí tự bao gồm nhiều từ:");
		String input = scanner.nextLine();
		String[] words = input.split(" ");
		int wordCount = 0;
		for (String word : words) {
			if (!word.equals("")) {
				wordCount++;
				System.out.println(wordCount + ": " + word);
			}
		}
		
		System.out.println("Số lượng từ có trong xâu kí tự bạn vừa nhập: " + wordCount);
	}
	
//	Question 2:
//	Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
	public static void question2() {
		System.out.println("\n-- Question 2:");
		System.out.println("Nhập vào string thứ nhất:");
		String s1 = scanner.nextLine();
		System.out.println("Nhập vào string thứ hai:");
		String s2 = scanner.nextLine();
		
		// Cách 1:
		String s3 = s1 + s2;
		System.out.println("Cách 1: \n" + s3);
		
		// Cách 2:
		String s4 = s1.concat(s2);
		System.out.println("Cách 2: \n" + s4);
	}
	
//	Question 3:
//	Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chưa
//	viết hoa chữ cái đầu thì viết hoa lên
	public static void question3() {
		System.out.println("\n-- Question 3:");
		System.out.println("Nhập họ và tên:");
		String input = scanner.nextLine().trim();
		char[] charArr = input.toCharArray();
		
		String output = "";
		boolean isNextUpper = true;
		for (int i = 0; i < charArr.length; i++) {
			char curChar = charArr[i];
			if (isNextUpper) {
				output += String.valueOf(curChar).toUpperCase();
				isNextUpper = false;
			} else {
				output += String.valueOf(curChar).toLowerCase();
			}
			if (curChar == ' ') {
				isNextUpper = true;
			}
		}
		
		System.out.println("Họ và tên bạn vừa nhập: \"" + output + "\"");
	}
	
//	Question 4:
//	Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//	của người dùng ra
//	VD: Người dùng nhập vào "Nam", hệ thống sẽ in ra
//	"Ký tự thứ 1 là: N"
//	"Ký tự thứ 1 là: A"
//	"Ký tự thứ 1 là: M"
	public static void question4() {
		System.out.println("\n-- Question 4:");
		System.out.println("Nhập họ và tên:");
		String input = scanner.nextLine().trim();
		char[] charArr = input.toCharArray();
		
		for (int i = 0; i < charArr.length; i++) {
			char curChar = Character.toUpperCase(charArr[i]);
			if (curChar != ' ') {
				System.out.println("Ký tự thứ " + i + " là: " + curChar);
			}
		}
	}
	
//	Question 5:
//	Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//	dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	public static void question5() {
		System.out.println("\n-- Question 5:");
		System.out.println("Nhập họ:");
		String familyName = scanner.nextLine().trim();
		System.out.println("Nhập tên:");
		String firstName = scanner.nextLine().trim();
		
		System.out.println("Xin chào, " + familyName + " " + firstName);
	}
	
//	Question 6:
//	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//	sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//	VD: Người dùng nhập vào "Nguyễn Văn Nam"
//	Hệ thống sẽ in ra
//	"Họ là: Nguyễn"
//	"Tên đệm là: Văn"
//	"Tên là: Nam"
	public static void question6() {
		System.out.println("\n-- Question 6:");
		System.out.println("Nhập họ và tên đầy đủ (bao gồm họ, tên đệm, và tên):");
		String input = scanner.nextLine().trim();
		String[] words = input.split(" ");
		words = removeNullStrings(words);
		
		System.out.println("Họ là: " + words[0]);
		System.out.println("Tên đệm là: " + words[1]);
		System.out.println("Tên là: " + words[2]);
	}
	
	private static String[] removeNullStrings(String[] input) {
		String[] output = new String[3];
		int i = 0;
		for (String string : input) {
			if (!string.equals("")) {
				output[i++] = string;
			}
			if (i == 3) {
				break;
			}
		}
		return output;
	}
	
//	Question 7:
//	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//	chuẩn hóa họ và tên của họ như sau:
//	a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập
//	vào. VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//	chuẩn hóa thành "nguyễn văn nam"
//	b) Viết hoa chữ cái mỗi từ của người dùng
//	VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//	chuẩn hóa thành "Nguyễn Văn Nam"
	public static void question7() {
		System.out.println("\n-- Question 7: (same as question 3)");
		System.out.println("Nhập họ và tên:");
		String input = scanner.nextLine().trim();
		char[] charArr = input.toCharArray();
		
		String output = "";
		boolean isNextUpper = true;
		for (int i = 0; i < charArr.length; i++) {
			char curChar = charArr[i];
			if (isNextUpper) {
				output += String.valueOf(curChar).toUpperCase();
				isNextUpper = false;
			} else {
				output += String.valueOf(curChar).toLowerCase();
			}
			if (curChar == ' ') {
				isNextUpper = true;
			}
		}
		
		System.out.println("Họ và tên bạn vừa nhập: \"" + output + "\"");
	}
	
//	Question 8:
//	In ra tất cả các group có chứa chữ "Java"
	public static void question8() {
		System.out.println("\n-- Question 8:");
		System.out.println("In ra tất cả các group có chứa chữ \"Java\"");
		for (Group group : groups) {
			if (group.name.contains("Java")) {
				System.out.println(group.name);
			}
		}
	}
	
//	Question 9:
//	In ra tất cả các group "Java"
	public static void question9() {
		System.out.println("\n-- Question 9:");
		System.out.println("In ra tất cả các group \"Java\"");
		for (Group group : groups) {
			if (group.name.equals("Java")) {
				System.out.println(group.name);
			}
		}
	}
	
//	Question 10 (Optional):
//	Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//	Nếu có xuất ra “OK” ngược lại “KO”.
//	Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
	public static void question10() {
		System.out.println("\n-- Question 10:");
		System.out.println("Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.");
		System.out.println("Nhập vào chuỗi thứ nhất:");
		String string1 = scanner.nextLine().trim();
		System.out.println("Nhập vào chuỗi thứ hai:");
		String string2 = scanner.nextLine().trim();
		
		boolean isRevesed = true;
		char[] charArr1 = string1.toCharArray();
		char[] charArr2 = string2.toCharArray();
		
		if (charArr1.length != charArr2.length) {
			isRevesed = false;
		} else {
			int length = charArr1.length;
			for (int i = 0; i < length; i++) {
				char curChar = charArr1[i];
				char oppoChar = charArr2[length - 1 - i];
				if (curChar != oppoChar) {
					isRevesed = false;
				}
			}
		}
		
		System.out.println("“" + string1 + "” và “" + string2 + "”"
			+ (isRevesed ? "" : " không")
			+ " là 2 chuỗi đảo ngược nhau.");
	}
	
//	Question 11 (Optional): Count special Character
//	Tìm số lần xuất hiện ký tự "a" trong chuỗi
	public static void question11() {
		System.out.println("\n-- Question 11:");
		System.out.println("Nhập vào một chuỗi:");
		String input = scanner.nextLine().trim().toLowerCase();
		System.out.println("Nhập vào ký tự hoặc chuỗi ký tự cần tìm:");
		String special = scanner.nextLine().trim().toLowerCase();
		
		String[] splitRemains = input.split(special);
		int count = splitRemains.length - 1;
		System.out.println("Số lần xuất hiện của \"" + special + "\" trong chuỗi là: " + count);
	}
	
//	Question 12 (Optional): Reverse String
//	Đảo ngược chuỗi sử dụng vòng lặp
	public static void question12() {
		System.out.println("\n-- Question 12:");
		System.out.println("Nhập vào một chuỗi:");
		String input = scanner.nextLine().trim();
		
		char[] inputCharArr = input.toCharArray(); 
		String output = "";
		int length = inputCharArr.length;
		for (int i = 0; i < length; i++) {
			output += String.valueOf(inputCharArr[length - 1 - i]);
		}
		System.out.println("Đảo ngược chuỗi vừa nhập: \n" + output);
	}
	
//	Question 13 (Optional): String not contains digit
//	Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
//	lại true.
//	Ví dụ:
//	"abc" => true
//	"1abc", "abc1", "123", "a1bc", null => false
	public static void question13() {
		System.out.println("\n-- Question 13:");
		boolean hasNumber = false;
		System.out.println("Nhập vào một chuỗi:");
		String input = scanner.nextLine().trim();
		
		for (int i = 0; i < 10; i++) {
			String numberString = String.valueOf(i);
			hasNumber = input.contains(numberString);
			if (hasNumber) {
				break;
			}
		}
		
		System.out.println("Chuỗi có chứa chữ số hay không: " + hasNumber);
	}
	
//	Question 14 (Optional): Replace character
//	Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
//	cho trước.
//	Ví dụ: "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
	public static void question14() {
		System.out.println("\n-- Question 14:");
		System.out.println("Nhập vào một chuỗi:");
		String input = scanner.nextLine().trim();
		System.out.println("Nhập vào ký tự muốn thay:");
		String targetChar = scanner.nextLine().trim();
		System.out.println("Nhập vào ký tự mới:");
		
		String replaceChar = scanner.nextLine().trim();
		String output = input.replace(targetChar, replaceChar);
		System.out.println("Kết quả: \n" + output);
	}
	
//	Question 15 (Optional): Revert string by word
//	Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
//	thư viện.
//	Ví dụ: " I am developer " => "developer am I".
//	Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//	Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
//	chuỗi theo dấu cách
	public static void question15() {
		System.out.println("\n-- Question 15:");
		System.out.println("Nhập vào một chuỗi:");
		String input = scanner.nextLine().trim();
		
		String[] inputCharArr = input.split(" "); 
		String output = "";
		int length = inputCharArr.length;
		for (int i = 0; i < length; i++) {
			output += inputCharArr[length - 1 - i];
			output += (i == length - 1 ? "" : " ");
		}
		System.out.println("Đảo ngược chuỗi vừa nhập: \n" + output);
	}
	
//	Question 16 (Optional):
//	Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
//	bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
//	hình “KO”.
	public static void question16() {
		System.out.println("\n-- Question 16:");
		System.out.println("Nhập vào một chuỗi:");
		String inputString = scanner.nextLine().trim();
		int length = inputString.length();
		System.out.println("Độ dài của chuỗi là: " + length);
		System.out.println("Nhập vào một số nguyên lớn hơn 0:");
		int inputInt = scanner.nextInt();
		scanner.nextLine();
		
		if (inputInt <= 0) {
			return;
		}
		
		if (length % inputInt == 0) {
			int outputArrLength = length / inputInt;
			String[] output = new String[outputArrLength];

			for (int i = 0; i < output.length; i++) {
				int startIndex = i * inputInt;
				int endIndex = (i + 1) * inputInt - 1;
				output[i] = inputString.substring(startIndex, endIndex);
			}
			
			System.out.println("Kết quả:");
			for (String string : output) {
				System.out.println("\"" + string + "\"");
			}
			
		} else {
			System.out.println("KO");
		}
	}
}
