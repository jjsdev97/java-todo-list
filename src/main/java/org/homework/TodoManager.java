package org.homework;

import java.util.*;


public class TodoManager {
    private int idCnt = 1;
    private HashMap<Integer, String> toDoListMap = new HashMap<>();
    private HashMap<Integer, String> toDoListStatusMap = new HashMap<>();



    public int addToDoList(String inputStr) {
        return (toDoListMap.put(idCnt, inputStr)==null) ? idCnt++ : -1;
    }

    public int doneToDoList(int input) {

        if(toDoListStatusMap.containsKey(input)){
            return 0;
        }

        if(toDoListMap.containsKey(input)) {
            toDoListStatusMap.put(input, "[완료]");
            return input;
        }

        return -1;
    }


    public int removeToDoList(int input) {
        return (toDoListMap.remove(input) != null) ? input : -1;
    }

    public ArrayList<Integer> getKeyArray(){
        ArrayList<Integer> keyArr = new ArrayList<>();

        Set<Integer> keySet = toDoListMap.keySet();

        for(int key : keySet){
            keyArr.add(key);
        }

        return keyArr;
    }


    public boolean hasToDoList(int input) {
        return toDoListMap.containsKey(input);
    }

    public String getContent(int input) {
        return toDoListMap.get(input);
    }

    public String getIsDone(int input) {
        return toDoListStatusMap.containsKey(input) ? toDoListStatusMap.get(input) : "";
    }

    public ArrayList<Integer> search(String keyword) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int key : toDoListMap.keySet()){
            if(toDoListMap.get(key).contains(keyword)){
                result.add(key);
            }
        }

        return result;
    }

}

