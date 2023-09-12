package org.homework.repository;

import org.homework.constant.SortOptionEnum;
import org.homework.constant.StatusSelectOptionEnum;
import org.homework.entity.Todo;

import java.util.List;

public interface TodoRepository {
    public int addToDoList(String inputStr);

    public int doneToDoList(int input);

    public int removeToDoList(int input);

    public List<Todo> getTodoList();

    public List<Todo> sortTodoList(SortOptionEnum option);

    public List<Todo> statusTodoList(StatusSelectOptionEnum option);

    public Todo getTodo(int input);

    public List<Todo> search(String keyword);

}
