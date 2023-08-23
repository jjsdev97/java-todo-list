package org.homework;

import java.util.HashMap;

public class TodoManager {
    private int idCnt = 1;
    private HashMap<Integer, String> toDoListMap = new HashMap<>();


    public int addToDoList(String inputStr) {
        return (toDoListMap.put(idCnt, inputStr)==null) ? idCnt++ : -1;
    }

    public int removeToDoList(int input) {
        return (toDoListMap.remove(input) != null) ? input : -1;
    }

    public String viewToDoList(int input) {
        return (toDoListMap.containsKey(input)) ? toDoListMap.get(input) : null;
    }
}

