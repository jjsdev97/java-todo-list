package org.homework.repository;

import org.homework.entity.Todo;

import java.util.List;

public interface TodoRepository {
    public int save(String todoContent);

    public int updateById(Todo input);

    public int deleteById(int input);

    public List<Todo> findAll();

    public Todo findById(int input);



}
