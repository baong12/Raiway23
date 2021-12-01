package com.vti.backend;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.News;

public class Exercise1 {
	private News[] newsList;
	private final int MAX_RATE_COUNT = 3;

	public void myNews() {
		newsList = new News[] {};
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;

		while (isContinue) {
			System.out.println("--------- My News ----------");
			System.out.println("Chọn chức năng:");
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");
			int select = scanner.nextInt();
			scanner.nextLine();

			switch (select) {
			case 1:
				insertNewsUI(scanner);
				break;
			case 2:
				viewListNews();
				break;
			case 3:
				AverageRateUI();
				break;
			case 4:
				isContinue = false;
				continue;
			default:
				System.out.println("Xin mời chọn lại");
				break;
			}

			System.out.println("Tiếp tục? 1. Có, 2. Không");
			select = scanner.nextInt();
			scanner.nextLine();
			isContinue = select == 1;
		}

		scanner.close();
	}

	private void insertNewsUI(Scanner scanner) {
		System.out.println("Nhập tiêu đề:");
		String title = scanner.nextLine();
		System.out.println("Nhập ngày xuất bản:");
		String publishDate = scanner.nextLine();
		System.out.println("Nhập tác giả:");
		String author = scanner.nextLine();
		System.out.println("Nhập nội dung:");
		String content = scanner.nextLine();

		int[] rates = new int[] {};
		for (int i = 0; i < MAX_RATE_COUNT; i++) {
			System.out.println("Nhập rate " + (i + 1) + ":");
			int rate = scanner.nextInt();
			rates = ArrayUtils.add(rates, rate);
		}
		scanner.nextLine();
		News newNews = new News(newsList.length, title, publishDate, author, content, rates);

		newsList = ArrayUtils.add(newsList, newNews);
		System.out.println("Thêm thành công");
		newNews.Display();
	}

	private void viewListNews() {
		if (newsList.length > 0) {
			System.out.println("Danh sách tin tức:");
			for (News news : newsList) {
				news.Display();
			}
		} else {
			System.out.println("Không có tin tức");
		}
	}

	private void AverageRateUI() {
		if (newsList.length > 0) {
			System.out.println("Tính toán rate trung bình");
			for (News news : newsList) {
				news.Calculate();
				news.Display();
			}
		} else {
			System.out.println("Không có tin tức");
		}
	}
}
