package org.homework;

import java.util.*;


public class TodoManager {
    private int idCnt = 1;
    private HashMap<Integer, Todo> toDoListMap = new HashMap<>();



    public int addToDoList(String inputStr) {
        Todo todo = new Todo();
        todo.setContent(inputStr);
        return (toDoListMap.put(idCnt, todo)==null) ? idCnt++ : -1;
    }

    public int doneToDoList(int input) {

        if(toDoListMap.containsKey(input)) {
            if(toDoListMap.get(input).isStatus()){
                return 0;
            }
            toDoListMap.get(input).changeStatus();
            return input;
        }

        return -1;
    }


    public int removeToDoList(int input) {

        if(toDoListMap.containsKey(input)){
            toDoListMap.remove(input);

            return input;
        }
        return -1;
    }

    public ArrayList<Integer> getKeyArray(){
        ArrayList<Integer> keyArr = new ArrayList<>();

        Set<Integer> keySet = toDoListMap.keySet();

        for(int key : keySet){
            keyArr.add(key);
        }

        return keyArr;
    }

    public ArrayList<Integer> sortKeyArray(String option){
        ArrayList<Integer> keyArr = getKeyArray();

        if(option.equals("DESC")){
            keyArr.sort(Comparator.reverseOrder());
        }else if(option.equals("ASC")){
            keyArr.sort(Comparator.naturalOrder());
        }

        return keyArr;
    }


    public boolean hasToDoList(int input) {
        return toDoListMap.containsKey(input);
    }

    public String getContent(int input) {
        return toDoListMap.get(input).getContent();
    }

    public String getIsDone(int input) {
        return toDoListMap.get(input).isStatus() ? "[완료]" : "";
    }

    public ArrayList<Integer> search(String keyword) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int key : toDoListMap.keySet()){
            if(toDoListMap.get(key).getContent().contains(keyword)){
                result.add(key);
            }
        }

        return result;
    }

}

