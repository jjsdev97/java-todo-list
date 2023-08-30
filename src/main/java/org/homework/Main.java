package org.homework;

public class Main {
    public static void main(String[] args) throws Exception {
        Todo todoList = new Todo();
        TodoManager todoManager = new TodoManager();
        TodoUI todoUI = new TodoUI(todoList, todoManager);

        todoUI.run();
    }
}


