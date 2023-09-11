package org.homework;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DAO {
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


    public void add(Todo todo) {
        try(SqlSession session = getSession()) {
            session.insert("todoListMapper.add", todo);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
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

    public int delete(int id) {
        int result = 0;

        try(SqlSession session = getSession()) {
            result =  session.delete("todoListMapper.delete", id);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    public Todo getTodo(int id) {
        Todo todo = null;

        try(SqlSession session = getSession()) {
            todo = session.selectOne("todoListMapper.getTodo", id);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return todo;
    }

    public int done(Todo todo) {
        int result = 0;
        try(SqlSession session = getSession()) {
            result = session.update("todoListMapper.done", todo);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return result;
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
}
