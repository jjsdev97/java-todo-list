package org.homework;

import org.homework.controller.TodoUI;
import org.homework.repository.MapTodoRepository;
import org.homework.repository.OracleTodoRepository;
import org.homework.repository.TodoRepository;
import org.homework.service.TodoService;
import org.homework.view.InputView;
import org.homework.view.TodoView;

public class Main {
    public static void main(String[] args) {
        TodoService todoService = new TodoService();
        TodoRepository mapTodoRepository = new MapTodoRepository(todoService);
        TodoRepository oracleTodoRepository = new OracleTodoRepository(todoService);

        InputView inputView = new InputView();
        TodoView todoView = new TodoView();
        TodoUI todoUI = new TodoUI(oracleTodoRepository, inputView, todoView);

        todoUI.run();
    }
}


