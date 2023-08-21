package org.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TodoUI  {

    public void start(TodoManager toDoManager) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = false;
        int option = -1; // 숫자로 입력받아서 옵션을 선택하는데 ENUM 사용법??

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
                    toDoManager.addTDL(br.readLine());
                    break;
                case 2: // 삭제
                    System.out.println("삭제할 할 일의 ID를 입력");
                    toDoManager.removeTDL(br.readLine());
                    break;
                case 3: // 조회
                    System.out.println("조회할 할 일의 ID를 입력");
                    toDoManager.selectTDL(br.readLine());
                    break;
                case 4: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    flag = true;
                    break;

            }

        }
    }
}
