package org.homework.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.homework.constant.SortOptionEnum;
import org.homework.constant.StatusSelectOptionEnum;
import org.homework.entity.Todo;
import org.homework.service.TodoService;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class OracleTodoRepository implements TodoRepository {
    TodoService todoService = null;
    private int idCnt = checkIdCnt();

    public OracleTodoRepository(TodoService todoService) {
        this.todoService = todoService;
    }

    private SqlSession getSession() {
        SqlSession session = null;
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
            session = sf.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }


    public int checkIdCnt() {
        int result = 0;
        try(SqlSession session = getSession()) {
            result = session.selectOne("todoListMapper.checkIdCnt");

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int addToDoList(String inputStr) {
        Todo todo = new Todo(idCnt, inputStr);
        try(SqlSession session = getSession()) {
            session.insert("todoListMapper.add", todo);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return idCnt++;
    }

    public int doneToDoList(int input) {
        Todo todo = getTodo(input);
        todoService.doneTodo(todo);

        try(SqlSession session = getSession()) {
            session.update("todoListMapper.done", todo);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return input;
    }

    public int removeToDoList(int id) {
        getTodo(id);
        try(SqlSession session = getSession()) {
            session.delete("todoListMapper.delete", id);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return id;
    }

    public Todo getTodo(int id) {
        Todo todo = null;

        try(SqlSession session = getSession()) {
            todo = session.selectOne("todoListMapper.getTodo", id);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        todoService.existsTodo(todo);
        return todo;
    }

    public List<Todo> getTodoList() {
        List<Todo> todoList = null;

        try(SqlSession session = getSession()) {
            todoList = session.selectList("todoListMapper.getTodoList");

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return todoList;
    }

    public List<Todo> sortTodoList(SortOptionEnum option){
        return todoService.sortTodoList(option, getTodoList());
    }

    public List<Todo> statusTodoList(StatusSelectOptionEnum option) {
        return todoService.statusFilterTodoList(option, getTodoList());
    }

    public List<Todo> search(String keyword) {
        return todoService.searchTodoList(keyword, getTodoList());
    }

}
