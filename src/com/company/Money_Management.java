package com.company;

import java.util.Scanner;

public class Money_Management {
    public static void main(String[] args) {
        int arr[]={50000,10000,1000,500,100,50,10,1};
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int result=0;
        for(int i= 0;n!=0;i++){
            result=n/arr[i];
            System.out.printf("%d권이 %d번 사용 되었습니다.\n", arr[i], result);
            n=n-result*arr[i];
        }
    }
}
