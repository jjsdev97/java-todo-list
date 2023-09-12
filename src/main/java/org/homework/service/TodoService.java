package org.homework.service;

import org.homework.constant.SortOptionEnum;
import org.homework.constant.StatusSelectOptionEnum;
import org.homework.entity.Todo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TodoService {

    public Todo doneTodo(Todo todo){
        if(todo.getStatus().isDone()) throw new RuntimeException("이미 완료한 할 일입니다.");

        todo.done();
        return todo;
    }

    public List<Todo> sortTodoList(SortOptionEnum option, List<Todo> todoList){
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

    public List<Todo> statusFilterTodoList(StatusSelectOptionEnum option, List<Todo> todoList) {
        switch(option){
            case TODO:
                return todoList.stream().filter(todo -> todo.getStatus().isTodo()==true).collect(Collectors.toList());
            case DOING:
                return todoList.stream().filter(todo -> todo.getStatus().isDoing()==true).collect(Collectors.toList());
            case DONE:
                return todoList.stream().filter(todo -> todo.getStatus().isDone()==true).collect(Collectors.toList());
        }

        return todoList;
    }

    public List<Todo> searchTodoList(String keyword, List<Todo> todoList) {
        return todoList.stream()
                .filter(todo -> todo.isContainKeyword(keyword) == true)
                .collect(Collectors.toList());
    }


    public void existsTodo(Todo todo) {
        if(todo==null) throw new RuntimeException("해당 ID의 할 일이 없습니다.");
    }


    public void existsTodo(int input, HashMap<Integer, Todo> toDoListMap) {
        if(!toDoListMap.containsKey(input)) throw new RuntimeException("해당 ID의 할 일이 없습니다.");
    }
}
