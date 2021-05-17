package com.company;

import java.util.Scanner;

public class Rock_paper_scissors {
    public static void main(String[] args) {
        String 가위;
        String 바위;
        String 보;
        Scanner a = new Scanner(System.in);
        System.out.println("가위 바위 보 게임입니다. 가위,바위,보 중에서 입력하세요.");
        System.out.print("철수<<");
        String 철수 = a.next();
        System.out.print("영희<<");
        String 영희 = a.next();
        if (철수.equals("가위")) {
            if (영희.equals("바위")) {
                System.out.println("영희가 이겼습니다.");
            } else if (영희.equals("바위")) {
                System.out.println("비겼습니다.");
            } else {
                System.out.println("철수가 이겼습니다.");
            }
        }
        if (철수.equals("바위")) {
            if (영희.equals("보")) {
                System.out.println("영희가 이겼습니다.");
            } else if (영희.equals("바위")) {
                System.out.println("비겼습니다.");
            } else {
                System.out.println("철수가 이겼습니다.");
            }
        }
        if (철수.equals("보")) {
            if (영희.equals("바위")) {
                System.out.println("철수가 이겼습니다.");
            } else if (영희.equals("가위")) {

                System.out.println("영희가 이겼습니다.");
            } else {
                System.out.println("비겼습니다.");
            }
        }

    }
}