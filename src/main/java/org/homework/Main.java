package org.homework;

public class Main {
    public static void main(String[] args) {
        TodoManager todoManager = new TodoManager();
        InputView inputView = new InputView();
        TodoView todoView = new TodoView();
        TodoUI todoUI = new TodoUI(todoManager, inputView, todoView);

        todoUI.run();
    }
}


