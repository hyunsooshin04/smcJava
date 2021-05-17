package com.company;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean run=true;
        Scanner sc=new Scanner(System.in);
        System.out.printf("게임에 참가하는 인원은 몇명입니까? : ");
        int n=sc.nextInt();
        sc.nextLine();
        String arr[]=new String[n];
        for(int i=1;i<=n;i++){
            System.out.printf("%d님의 이름을 입력해주세요.\n",i);
            arr[i-1]=sc.nextLine();
        }
        int index=0,cnt=0;
        char first,last;
        String wd="아버지";
        System.out.printf("첫 시작 단어는 '아버지' 입니다\n");
        while(run){
            index=wd.length()-1;
            last=wd.charAt(index);
            System.out.printf("%s : ", arr[cnt]);
            wd=sc.nextLine();
            first=wd.charAt(0);
            if(last==first){
                cnt++;
                if(cnt>=n){
                    cnt=0;
                }
            }
            else{
                System.out.printf("%s님이 패배하셨습니다.",arr[cnt]);
                run=false;
            }
        }
    }
}