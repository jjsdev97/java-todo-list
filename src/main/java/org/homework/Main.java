package org.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ToDoList tdl = new ToDoList();

        boolean flag = false;
        int option = -1;

        while(!flag) {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");

            try{
                option = Integer.parseInt(br.readLine());

                if(option > 4 || option < 1){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
            }catch(NumberFormatException e){
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            switch(option){
                case 1: // 추가
                    System.out.print("할 일의 내용을 입력 : ");
                    tdl.addTDL(br.readLine());
                    break;
                case 2: // 삭제
                    System.out.println("삭제할 할 일의 ID를 입력");
                    tdl.removeTDL(br.readLine());
                    break;
                case 3: // 조회
                    System.out.println("조회할 할 일의 ID를 입력");
                    tdl.selectTDL(br.readLine());
                    break; 
                case 4: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    flag = true;
                    break;

            }

        }
    }
}