package org.homework;

public class Main {
    public static void main(String[] args) {
        TodoRepository mapTodoRepository = new MapTodoRepository();
        TodoRepository oracleTodoRepository = new OracleTodoRepository();

        InputView inputView = new InputView();
        TodoView todoView = new TodoView();
        TodoUI todoUI = new TodoUI(oracleTodoRepository, inputView, todoView);

        todoUI.run();
    }
}


