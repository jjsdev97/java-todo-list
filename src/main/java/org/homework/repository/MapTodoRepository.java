package org.homework.repository;

import org.homework.entity.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapTodoRepository implements TodoRepository {
    private int idCnt = 1;
    private HashMap<Integer, Todo> todoListMap = new HashMap<>();

    @Override
    public int save(String todoContent) {
        Todo todo = new Todo(idCnt, todoContent);
        todoListMap.put(idCnt, todo);
        return idCnt++;
    }

    @Override
    public Todo findById(int input) {
        return todoListMap.get(input);
    }

    @Override
    public int updateById(Todo todo) {
        int id = todo.getId();
        todoListMap.replace(id, todo);
        return id;
    }

    @Override
    public int deleteById(int id) {
        todoListMap.remove(id);
        return id;
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todoListMap.values());
    }










}

