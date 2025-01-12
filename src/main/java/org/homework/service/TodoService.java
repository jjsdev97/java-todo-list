package org.homework.service;

import org.homework.constant.SortOptionEnum;
import org.homework.constant.StatusSelectOptionEnum;
import org.homework.entity.Todo;
import org.homework.repository.TodoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public int addTodoList(String todoContent) {
        return todoRepository.save(todoContent);
    }

    public Todo findById(int id) {
        Todo todo = todoRepository.findById(id);
        if(todo==null) throw new RuntimeException("해당 ID의 할 일이 없습니다.");

        return todo;
    }

    public int doneTodo(int id) {
        Todo todo = findById(id);
        if(todo.isDone()) throw new RuntimeException("이미 완료한 할 일입니다.");

        todo.done();
        todoRepository.updateById(todo);

        return id;
    }

    public int removeTodo(int id) {
        findById(id);
        todoRepository.deleteById(id);

        return id;
    }

    public List<Todo> getTodoList() {
        List<Todo> todoList = todoRepository.findAll();
        return todoList;
    }

    public List<Todo> sortTodoList(SortOptionEnum option){
        List<Todo> todoList = getTodoList();

        switch(option){
            case DESC:
                return todoList.stream()
                        .sorted(Comparator.comparingInt(Todo::getId).reversed())
                        .collect(Collectors.toList());
            case ASC:
                return todoList.stream()
                        .sorted(Comparator.comparingInt(Todo::getId))
                        .collect(Collectors.toList());
        }

        return todoList;
    }

    public List<Todo> statusFilterTodoList(StatusSelectOptionEnum option) {
        List<Todo> todoList = getTodoList();

        switch(option){
            case TODO:
                return todoList.stream()
                        .filter(todo -> todo.isTodo())
                        .collect(Collectors.toList());
            case DOING:
                return todoList.stream()
                        .filter(todo -> todo.isDoing())
                        .collect(Collectors.toList());
            case DONE:
                return todoList.stream()
                        .filter(todo -> todo.isDone())
                        .collect(Collectors.toList());
        }

        return todoList;
    }

    public List<Todo> searchTodoList(String keyword) {
        List<Todo> todoList = getTodoList();

        return todoList.stream()
                .filter(todo -> todo.isContainKeyword(keyword))
                .collect(Collectors.toList());
    }



}
