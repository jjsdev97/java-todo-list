package org.homework;

public class Main {
    public static void main(String[] args) throws Exception {
        TodoManager todoManager = new TodoManager();
        TodoUI todoUI = new TodoUI(todoManager);

        todoUI.run();
    }
}


