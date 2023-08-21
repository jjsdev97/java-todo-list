package org.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TodoUI  {

    public void start(TodoManager toDoManager) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = false;
        int option = -1; // 숫자로 입력받아서 옵션을 선택하는데 ENUM 사용법??
        int result = 0;

        String resultStr = null;

        while(true) {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");

                option = toDoManager.isNumber(br.readLine());
                if(option == -1) continue;

                if(option > 4 || option < 1){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }


            switch(option){
                case 1: // 추가
                    System.out.print("할 일의 내용을 입력 : ");

                    result = toDoManager.addTDL(br.readLine());

                    if(result>0){
                        System.out.printf("할 일이 추가되었습니다. ID: %d\n", result);
                    }else {
                        System.out.println("할 일을 추가하는데 실패했습니다.");
                    }

                    break;

                case 2: // 삭제
                    System.out.println("삭제할 할 일의 ID를 입력");

                    result = toDoManager.removeTDL(br.readLine());

                    if(result==0){
                        System.out.println("해당 ID의 할 일이 없습니다.");
                    }else if(result>0){
                        System.out.printf("할 일이 삭제되었습니다. ID: %d\n", result);
                    }

                    break;

                case 3: // 조회
                    System.out.println("조회할 할 일의 ID를 입력");
                    String input = br.readLine();
                    resultStr = toDoManager.selectTDL(input);
                    if(resultStr != null){
                        System.out.println(resultStr);
                    }

                    break;
                case 4: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

            }

        }
    }
}
