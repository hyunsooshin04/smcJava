package com.company;

import java.util.Scanner;

public class Magnet_Management {

    public static void main(String[] args) {
        String[][] S=new String[3][10];
        for(int i=0;i<3;i++){
            for(int j=0;j<10;j++){
                S[i][j]="---";
            }
        }
        String name="";
        int sit=0;
        Scanner sc=new Scanner(System.in);
        SAB sb=new SAB();
        int h;
        boolean run=true;
        while(run){
            sb.menu();
            System.out.printf(">>");
            int n=sc.nextInt();
            sc.nextLine();

            if(n==1){
                sb.Reservation(sit, S);
            }
            else if(n==2){
                sb.Search(S);
            }
            else if(n==3){

                sb.Cancellation(S);
            }
            else if(n==4){
                run=false;
            }
            else{
                System.out.printf("잘못 선택하셨습니다.\n다시 선택해주세요.\n");
            }
        }

    }

    public static class SAB {
        static void menu(){
            System.out.printf("예약<1>, 조회<2>, 취소<3>, 끝내기<4>\n");
        }
        static void Reservation(int sit, String[][] arr){
            Scanner sc=new Scanner(System.in);
            System.out.printf("좌석 부분 = S=1, A=2, B=3\n>>");
            int h=sc.nextInt();
            sc.nextLine();
            String ar[]={"S","A","B"};
            System.out.printf("%s>>", ar[h-1]);
            for(int i=0;i<10;i++){
                System.out.printf("%s ", arr[h-1][i]);
            }
            String name="";
            System.out.printf("이름>>");
            name=sc.nextLine();
            System.out.printf("좌석 번호>>");
            sit=sc.nextInt();
            sc.nextLine();
            arr[h-1][sit-1]=name;
        }
        static void Search(String[][] arr){
            String ar[]={"S","A","B"};
            for(int i=0;i<3;i++){
                for(int j=0;j<10;j++){
                    if(j==0){
                        System.out.printf("%s ", ar[i]);
                        System.out.printf("%s ", arr[i][j]);
                    }
                    else{
                        System.out.printf("%s ", arr[i][j]);
                    }
                }
                System.out.printf("\n");
            }
        }
        static void Cancellation(String[][] arr){
            Scanner sc=new Scanner(System.in);
            String ar[]={"S","A","B"};
            String ab="---";
            int result;
            System.out.printf("좌석 번호>>");
            int h=sc.nextInt();
            sc.nextLine();
            System.out.printf("%s ", ar[h-1]);
            for(int i=0;i<10;i++)System.out.printf("%s ", arr[h-1][i]);
            System.out.printf("이름>>");
            String name=sc.nextLine();
            for(int i=0;i<10;i++){
                if(name.equals(arr[h-1][i])){
                    arr[h-1][i]="---";
                }
            }
        }
    }
}