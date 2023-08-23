package org.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        TodoManager todoManager = new TodoManager();
        TodoUI todoUI = new TodoUI(todoManager);

        todoUI.run();
    }
}