package org.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TodoUI  {
    private TodoManager toDoManager = null;
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    TodoUI(TodoManager toDoManager){
        this.toDoManager = toDoManager;
    }

    public void run() throws Exception{
        while(true) {
            try{
                System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
                OptionEnum option = OptionEnum.of(br.readLine());

                switch(option){
                    case ADD:
                        add();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case VIEW:
                        view();
                        break;
                    case EXIT:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void add() throws Exception {
        System.out.print("할 일의 내용을 입력 : ");

        int result = toDoManager.addToDoList(br.readLine());
        if(result>0){
            System.out.printf("할 일이 추가되었습니다. ID: %d\n", result);
        }else {
            System.out.println("할 일을 추가하는데 실패했습니다.");
        }
    }

    private void delete() throws Exception {
        System.out.println("삭제할 할 일의 ID를 입력");

        int result = toDoManager.removeToDoList(isNumber(br.readLine()));

        if(result==-1){
            System.out.println("해당 ID의 할 일이 없습니다.");
        }else if(result>0){
            System.out.printf("할 일이 삭제되었습니다. ID: %d\n", result);
        }
    }

    private void view() throws Exception {
        System.out.println("조회할 할 일의 ID를 입력");
        int input = isNumber(br.readLine());
        String resultStr = toDoManager.viewToDoList(input);

        if(resultStr != null){
            System.out.printf("할 일 ID: %d , 내용: %s\n", input, resultStr);
        }else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    public int isNumber(String inputData){
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다.");
        }
    }
}
