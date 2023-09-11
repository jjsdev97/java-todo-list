package org.homework;

import java.io.IOException;

public class TodoUI  {
    private TodoRepository toDoRepositoryMap;
    private InputView inputView;
    private TodoView todoView;

    TodoUI(TodoRepository toDoRepositoryMap, InputView inputView, TodoView todoView){
        this.toDoRepositoryMap = toDoRepositoryMap;
        this.inputView = inputView;
        this.todoView = todoView;
    }

    public void run(){
        while(true) {
            try{
                System.out.println("--옵션을 선택하세요: 1. 추가, 2. 할 일 완료, 3. 삭제, 4. 조회(ID), 5. 전체 조회, 6. 전체 조회(정렬), " +
                        "7. 전체 조회(상태), 8. 검색, 9. 종료--");

                switch(inputView.getUserAction()){
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
                    case VIEWSTATUS:
                        viewStatus();
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

        todoView.showAddResult(toDoRepositoryMap.addToDoList(inputView.getTodoDetails()));
    }


    private void done() throws Exception {
        System.out.println("완료 할 일의 ID를 입력");

        todoView.showDoneResult(toDoRepositoryMap.doneToDoList(inputView.getInputNumber()));
    }

    private void delete() throws Exception {
        System.out.println("삭제할 할 일의 ID를 입력");

        todoView.showDeleteResult(toDoRepositoryMap.removeToDoList(inputView.getInputNumber()));
    }

    private void view() throws Exception {
        System.out.println("조회할 할 일의 ID를 입력");
        todoView.showToDo(toDoRepositoryMap.getTodo(inputView.getInputNumber()));

    }

    private void viewAll(){
        todoView.showToDos(toDoRepositoryMap.getTodoList());
    }

    private void viewSort() throws Exception {
        System.out.println("내림차순, 오름차순 정렬을 선택하세요 (1:오름차순, 2:내림차순)");
        todoView.showToDos(toDoRepositoryMap.sortTodoList(inputView.getSortOption()));
    }

    private void viewStatus() throws IOException {
        System.out.println("상태를 선택하세요. (1: 할 일, 2: 하는 중, 3: 완료)");
        todoView.showToDos(toDoRepositoryMap.statusTodoList(inputView.getStatusOption()));
    }


    private void search() throws Exception {
        System.out.println("검색할 키워드를 입력해주세요");
        todoView.showToDos(toDoRepositoryMap.search(inputView.getSearchKeyword()));
    }
}
