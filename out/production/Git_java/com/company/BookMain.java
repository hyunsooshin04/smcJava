package com.company;
import java.util.*;
import java.io.*;
public class BookMain {
	static Scanner sc=new Scanner(System.in);
	static String filepath="D:\\bookmanager\\book.txt";
	BufferedReader br;
	public static void main(String[] args) throws IOException {
		Engine e = new Engine();
		
		boolean run=true;
		while(run) {
			e.printmenu();
			int choice=-1;
			choice = e.choicenumber();
			if(choice==0) {
				System.out.println("프로그램을 종료합니다.");
				run=false;
			}
			else if(choice==1) {
				e.printbooks();
			}
			else if(choice==2) {
				e.searchbooks();
			}
			else if(choice==3) {
				e.insertbook();
			}
			else if(choice==4) {
				e.deletebook();
			}
			else {
				System.out.println("다시 선택해주세요.");
			}
		}
	}

}