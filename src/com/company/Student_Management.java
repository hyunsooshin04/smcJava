package com.company;

import java.util.Scanner;

public class Student_Management {
    public static void main(String[] args) {
        double arr[]= new double[100000];
        int student=0;//학생수
        boolean run=true;//종료를 위해 만든 변수
        Scanner scanf = new Scanner(System.in);
        while(run) {
            System.out.println("-------------------------------------");
            System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택>");
            int number=scanf.nextInt();
            if(number==1) {
                System.out.print("학생수>");
                int cheak=scanf.nextInt();
                student=cheak;
            }
            else if(number==2) {
                for(int i=1;i<=student;i++) {
                    System.out.print("학생"+ i +">");
                    arr[i-1]=scanf.nextInt();
                }
            }
            else if(number==3) {
                for(int i=1;i<=student;i++) {
                    System.out.println("학생"+ i +" : "+ arr[i-1]);
                }
            }
            else if(number==4) {
                double max=1;//최고점수
                double average=0;//평균점수
                for(int i=1;i<=student;i++) {
                    if(max<arr[i-1]) {
                        max=arr[i-1];
                    }
                    average=average+arr[i-1];//모든 학생점수 총합점
                }
                average=average/student;//나누기
                System.out.println("최고 점수 : "+ max);
                System.out.println("평균 점수 : "+ average);
            }
            else if(number==5) {
                System.out.println("프로그랩을 종료합니다.");
                run=false;
            }
        }
    }
}

