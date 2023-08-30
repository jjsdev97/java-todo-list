package org.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


public class TodoUI  {

    private Todo todo;
    private TodoManager toDoManager;
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    TodoUI(Todo todo, TodoManager toDoManager){
        this.todo = todo;
        this.toDoManager = toDoManager;
    }

    public void run() throws Exception{
        while(true) {
            try{
                System.out.println("--옵션을 선택하세요: 1. 추가, 2. 할 일 완료, 3. 삭제, 4. 조회(ID), 5. 전체 조회, 6. 전체 조회(정렬), " +
                        "7. 검색, 8. 종료--");

                OptionEnum option = OptionEnum.of(br.readLine());

                switch(option){
                    case ADD:
                        add();
                        break;
                    case DONE:
                        done();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case VIEW:
                        view();
                        break;
                    case VIEWALL:
                        viewAll();
                        break;
                    case VIEWSORT:
                        viewSort();
                        break;
                    case SEARCH:
                        search();
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


    private void done() throws Exception {
        System.out.println("완료 할 일의 ID를 입력");

        int result = toDoManager.doneToDoList(isNumber(br.readLine()));

        if(result>0){
            System.out.printf("할 일이 완료되었습니다. ID: %d\n", result);
        }else if(result==0){
            System.out.println("이미 완료한 할 일입니다.");
        }else {
            System.out.println("해당 ID의 할 일이 없습니다.");
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
        
        if(!printToDo(input)){
            System.out.println("해당 ID의 할 일이 없습니다.");
        }

    }

    private void viewAll() {
        ArrayList<Integer> keyArr = toDoManager.getKeyArray();
        printToDoList(keyArr);
    }

    private void viewSort() throws Exception {
        System.out.println("내림차순, 오름차순 정렬을 선택하세요 (1:오름차순, 2:내림차순)");
        SortOptionEnum option = SortOptionEnum.of(br.readLine());

        printToDoList(toDoManager.sortKeyArray(option.name()));
    }



    private void search() throws Exception {
        System.out.println("검색할 키워드를 입력해주세요");
        String keyword = br.readLine();

        ArrayList<Integer> searchResultArr = toDoManager.search(keyword);

        printToDoList(searchResultArr);
    }



    public int isNumber(String inputData){
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다.");
        }
    }


    public boolean printToDo(int input){

        if(toDoManager.hasToDoList(input)){
            String content = toDoManager.getContent(input);
            String isDone = toDoManager.getIsDone(input);

            System.out.printf("할 일 ID: %d , 내용: %s %s\n", input, content, isDone);

            return true;
        }

        return false;
    }

    private void printToDoList(ArrayList<Integer> keyArr) {
        if(keyArr.size()==0) {
            System.out.println("조회할 데이터가 없습니다.");
            return;
        }

        for(int key : keyArr){
            printToDo(key);
        }
    }



}
