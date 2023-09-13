package org.homework.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.homework.entity.Todo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class OracleTodoRepository implements TodoRepository {
    private int idCnt = checkIdCnt();

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

    @Override
    public int save(String todoContent) {
        Todo todo = new Todo(idCnt, todoContent);

        try(SqlSession session = getSession()) {
            session.insert("todoListMapper.add", todo);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return idCnt++;
    }

    @Override
    public Todo findById(int id) {
        Todo todo = null;

        try(SqlSession session = getSession()) {
            todo = session.selectOne("todoListMapper.getTodo", id);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return todo;
    }

    @Override
    public int updateById(Todo todo) {
        try(SqlSession session = getSession()) {
            session.update("todoListMapper.done", todo);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return todo.getId();
    }

    @Override
    public int deleteById(int id) {
        try(SqlSession session = getSession()) {
            session.delete("todoListMapper.delete", id);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> todoList = null;

        try(SqlSession session = getSession()) {
            todoList = session.selectList("todoListMapper.getTodoList");

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return todoList;
    }





}
