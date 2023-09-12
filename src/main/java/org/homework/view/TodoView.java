package org.homework.view;

import org.homework.entity.Todo;

import java.util.List;

public class TodoView {

    public void showAddResult(int input){
        System.out.printf("할 일이 추가되었습니다. ID: %d\n", input);
    }

    public void showDoneResult(int input){
        System.out.printf("할 일이 완료되었습니다. ID: %d\n", input);
    }

    public void showDeleteResult(int input) {
        System.out.printf("할 일이 삭제되었습니다. ID: %d\n", input);
    }

    public void showToDo(Todo todo){
        System.out.println(todo);
    }

    public void showToDos(List<Todo> todoList) {
        if(todoList.size()==0) throw new RuntimeException("조회할 데이터가 없습니다");

        for(Todo todo : todoList){
            showToDo(todo);
        }
    }
}
