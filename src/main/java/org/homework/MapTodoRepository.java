package org.homework;

import java.util.*;
import java.util.stream.Collectors;


public class MapTodoRepository implements TodoRepository {
    private int idCnt = 1;
    private HashMap<Integer, Todo> toDoListMap = new HashMap<>();

    public int addToDoList(String inputStr) {
        Todo todo = new Todo(idCnt, inputStr);
        toDoListMap.put(idCnt, todo);
        return idCnt++;
    }

    public int doneToDoList(int input) {
        Todo todo = toDoListMap.get(input);

        if(todo==null) throw new RuntimeException("해당 ID의 할 일이 없습니다.");

        if(todo.getStatus().isTodo()){
            toDoListMap.get(input).done();
        }else if(todo.getStatus().isDone()){
            throw new RuntimeException("이미 완료한 할 일입니다.");
        }

        return input;
    }

    public int removeToDoList(int input) {
        if(!toDoListMap.containsKey(input)) throw new RuntimeException("해당 ID의 할 일이 없습니다.");

        toDoListMap.remove(input);
        return input;
    }

    public List<Todo> getTodoList() {
        return new ArrayList<>(toDoListMap.values());
    }


    public List<Todo> sortTodoList(SortOptionEnum option){
        if(option==SortOptionEnum.DESC){
            return getTodoList().stream()
                    .sorted(Comparator.comparingInt(Todo::getId).reversed())
                    .collect(Collectors.toList());
        }

        return getTodoList();
    }

    public List<Todo> statusTodoList(StatusSelectOptionEnum option) {

        switch(option){
            case TODO:
                return getTodoList().stream().filter(todo -> todo.getStatus().isTodo()==true).collect(Collectors.toList());
            case DOING:
                return getTodoList().stream().filter(todo -> todo.getStatus().isDoing()==true).collect(Collectors.toList());
            case DONE:
                return getTodoList().stream().filter(todo -> todo.getStatus().isDone()==true).collect(Collectors.toList());
        }

        return getTodoList();

    }

    public Todo getTodo(int input) {
        if(!toDoListMap.containsKey(input)) throw new RuntimeException("해당 ID의 할 일이 없습니다.");
        return toDoListMap.get(input);
    }

    public List<Todo> search(String keyword) {
        return getTodoList().stream()
                .filter(todo -> todo.isContainKeyword(keyword) == true)
                .collect(Collectors.toList());

    }


}

