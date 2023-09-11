package org.homework;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OracleTodoRepository implements TodoRepository{
    DAO dao = new DAO();
    private int idCnt = dao.checkIdCnt();

    @Override
    public int addToDoList(String inputStr) {
        Todo todo = new Todo(idCnt, inputStr);
        dao.add(todo);
        return idCnt++;
    }

    @Override
    public int doneToDoList(int input) {
        Todo todo = dao.getTodo(input);

        if(todo==null) throw new RuntimeException("해당 ID의 할 일이 없습니다.");
        if(todo.getStatus().isDone()) throw new RuntimeException("이미 완료한 할 일입니다.");

        todo.done();

        dao.done(todo);
        return input;
    }

    @Override
    public int removeToDoList(int id) {
        int result = dao.delete(id);
        if(result==0) throw new RuntimeException("해당 ID의 할 일이 없습니다.");

        return id;
    }


    @Override
    public List<Todo> getTodoList() {
        return dao.getTodoList();
    }

    @Override
    public List<Todo> sortTodoList(SortOptionEnum option) {
        List<Todo> todoList = dao.getTodoList();
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

    @Override
    public List<Todo> statusTodoList(StatusSelectOptionEnum option) {
        switch(option){
            case TODO:
                return dao.getTodoList().stream().filter(todo -> todo.getStatus().isTodo()==true).collect(Collectors.toList());
            case DOING:
                return dao.getTodoList().stream().filter(todo -> todo.getStatus().isDoing()==true).collect(Collectors.toList());
            case DONE:
                return dao.getTodoList().stream().filter(todo -> todo.getStatus().isDone()==true).collect(Collectors.toList());
        }

        return getTodoList();
    }

    @Override
    public Todo getTodo(int input) {
        Todo todo = dao.getTodo(input);
        if(todo==null) throw new RuntimeException("해당 ID의 할 일이 없습니다.");
        return todo;
    }

    @Override
    public List<Todo> search(String keyword) {
        return dao.getTodoList().stream()
                .filter(todo -> todo.isContainKeyword(keyword) == true)
                .collect(Collectors.toList());
    }
}
