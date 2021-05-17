package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Engine {
	
	static Scanner sc=new Scanner(System.in);
	static String filepath="D:\\book\\book.txt";
	
	public int choicenumber() {
		int choice;
		choice=sc.nextInt();
		sc.nextLine();
		return choice;
	}
	
	public void printmenu() {
		System.out.println("도서관리 프로그램입니다.");
		System.out.println("------------------");
		System.out.println("1. 현재 목록 출력");
		System.out.println("2. 도서 검색");
		System.out.println("3. 신규 도서 추가");
		System.out.println("4. 노후 도서 폐기");
		System.out.println("0 .프로그램 종료");
		System.out.println("------------------");
		System.out.print("메뉴를 선택해주세요 : ");
	}
	
	public void searchbooks() throws IOException {
		System.out.print("검색할 키워드를 입력해주세요 : ");
		
		String keyword=sc.nextLine();
		String str="";
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		try {
			while ((str=br.readLine())!=null) {
				if(str.contains(keyword)) {
					System.out.println(str);
				}
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		}
		
	public void printbooks() throws FileNotFoundException {
		int cnt=1;
		System.out.println("책 출력");
		BufferedReader br=new BufferedReader(new FileReader(filepath));
		
		String str="";
		try {
			while((str=br.readLine())!=null) {
				System.out.println("("+ cnt +")" + str);
				cnt++;
			}
			br.close();
		} catch(IOException e){
			System.out.println("저장된 책을 찾을 수 없습니다.");
			System.out.println("저장된 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
		
	}
	
	public void insertbook() throws IOException {
		
		Book b= new Book();
		BufferedWriter bw=new BufferedWriter(new FileWriter(filepath, true));

		System.out.println("추가할 책의 정보를 입력해주세요.");
		System.out.print("책 이름 : ");
		b.name=sc.nextLine();

		System.out.print("책 저자 : ");
		b.author=sc.nextLine();

		System.out.print("출판사 : ");
		b.publisher=sc.nextLine();

		System.out.print("가격 : ");
		b.cost=sc.nextLine();
		
		System.out.println(b.tostring());
		
		bw.write(b.name + "\t" + b.author + "\t" + b.publisher + "\t" + b.cost);
		bw.newLine();
		bw.close();
	}
	
	public void deletebook() throws IOException {
		String tmpFilePath=filepath+".tmp";
		int cnt=1;
		System.out.print("삭제할 책 번호를 입력해주세요 : ");
		int delbooknum=sc.nextInt();
		System.out.println("책 번호 : "+ delbooknum);
		
		BufferedReader br=new BufferedReader(new FileReader(filepath));
		BufferedWriter bw=new BufferedWriter(new FileWriter(tmpFilePath));
		
		String str="";
		
		while((str=br.readLine())!=null) {
			if(cnt!=delbooknum) {
				bw.write(str);
				bw.write("\r\n");
			}
			cnt++;
		}
		bw.close();
		br.close();
		FileInputStream fis = new FileInputStream(tmpFilePath);
		FileOutputStream fos = new FileOutputStream(filepath);
		
		int data=0;
		while(	(data=fis.read()) != -1) {
			fos.write(data);
		}
		
		fis.close();
		fos.close();
		
		File f = new File(tmpFilePath);
		f.deleteOnExit();
		
	}
	
	
}