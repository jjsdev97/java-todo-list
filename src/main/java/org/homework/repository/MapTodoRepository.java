package org.homework.repository;

import org.homework.constant.SortOptionEnum;
import org.homework.constant.StatusSelectOptionEnum;
import org.homework.entity.Todo;
import org.homework.service.TodoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapTodoRepository implements TodoRepository {
    private int idCnt = 1;
    private HashMap<Integer, Todo> toDoListMap = new HashMap<>();
    TodoService todoService = null;

    public MapTodoRepository(TodoService todoService) {
        this.todoService = todoService;
    }

    public int addToDoList(String inputStr) {
        Todo todo = new Todo(idCnt, inputStr);
        toDoListMap.put(idCnt, todo);
        return idCnt++;
    }

    public int doneToDoList(int input) {
        Todo todo = toDoListMap.get(input);
        todoService.existsTodo(todo);
        todoService.doneTodo(todo);
        return input;
    }

    public int removeToDoList(int input) {
        todoService.existsTodo(input, toDoListMap);
        toDoListMap.remove(input);
        return input;
    }

    public List<Todo> getTodoList() {
        return new ArrayList<>(toDoListMap.values());
    }


    public List<Todo> sortTodoList(SortOptionEnum option){
        return todoService.sortTodoList(option, getTodoList());
    }

    public List<Todo> statusTodoList(StatusSelectOptionEnum option) {
        return todoService.statusFilterTodoList(option, getTodoList());
    }

    public Todo getTodo(int input) {
        todoService.existsTodo(input, toDoListMap);
        return toDoListMap.get(input);
    }

    public List<Todo> search(String keyword) {
        return todoService.searchTodoList(keyword, getTodoList());
    }


}

