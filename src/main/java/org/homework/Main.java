package org.homework;

import org.homework.controller.TodoController;
import org.homework.repository.MapTodoRepository;
import org.homework.repository.OracleTodoRepository;
import org.homework.repository.TodoRepository;
import org.homework.service.TodoService;
import org.homework.view.InputView;
import org.homework.view.TodoView;

public class Main {
    public static void main(String[] args) {
        TodoRepository mapTodoRepository = new MapTodoRepository();
        TodoRepository oracleTodoRepository = new OracleTodoRepository();

        TodoService todoService = new TodoService(oracleTodoRepository);

        InputView inputView = new InputView();
        TodoView todoView = new TodoView();
        TodoController todoController = new TodoController(todoService, inputView, todoView);

        todoController.run();
    }
}


