package org.homework.controller;

import org.homework.constant.SortOptionEnum;
import org.homework.constant.StatusSelectOptionEnum;
import org.homework.entity.Todo;
import org.homework.service.TodoService;
import org.homework.view.InputView;
import org.homework.view.TodoView;

import java.io.IOException;
import java.util.List;

public class TodoController {
    private TodoService todoService;
    private InputView inputView;
    private TodoView todoView;

    public TodoController(TodoService todoService, InputView inputView, TodoView todoView){
        this.todoService = todoService;
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

        String inputContent = inputView.getTodoDetails();
        int addTodoResult = todoService.addTodoList(inputContent);
        todoView.showAddResult(addTodoResult);
    }


    private void done() throws Exception {
        System.out.println("완료 할 일의 ID를 입력");

        int inputId = inputView.getInputNumber();
        int doneTodoResult = todoService.doneTodo(inputId);
        todoView.showDoneResult(doneTodoResult);
    }

    private void delete() throws Exception {
        System.out.println("삭제할 할 일의 ID를 입력");

        int inputId = inputView.getInputNumber();
        int removeTodoResult = todoService.removeTodo(inputId);
        todoView.showDeleteResult(removeTodoResult);
    }

    private void view() throws Exception {
        System.out.println("조회할 할 일의 ID를 입력");

        int inputId = inputView.getInputNumber();
        Todo getTodoResult = todoService.getTodo(inputId);
        todoView.showToDo(getTodoResult);
    }

    private void viewAll(){
        List<Todo> getTodoListResult = todoService.getTodoList();
        todoView.showToDos(getTodoListResult);
    }

    private void viewSort() throws Exception {
        System.out.println("내림차순, 오름차순 정렬을 선택하세요 (1:오름차순, 2:내림차순)");

        SortOptionEnum inputOption = inputView.getSortOption();
        List<Todo> getSortTodoListResult = todoService.sortTodoList(inputOption);
        todoView.showToDos(getSortTodoListResult);
    }

    private void viewStatus() throws IOException {
        System.out.println("상태를 선택하세요. (1: 할 일, 2: 하는 중, 3: 완료)");
        StatusSelectOptionEnum inputOption = inputView.getStatusOption();
        List<Todo> statusFilterTodoListResult = todoService.statusFilterTodoList(inputOption);
        todoView.showToDos(statusFilterTodoListResult);
    }


    private void search() throws Exception {
        System.out.println("검색할 키워드를 입력해주세요");
        String inputKeyword = inputView.getSearchKeyword();
        List<Todo> searchTodoListResult = todoService.searchTodoList(inputKeyword);
        todoView.showToDos(searchTodoListResult);
    }
}
