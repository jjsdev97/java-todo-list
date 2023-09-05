package org.homework;

import java.util.*;


public class TodoManager {
    private int idCnt = 1;
    private HashMap<Integer, Todo> toDoListMap = new HashMap<>();

    public int addToDoList(String inputStr) {
        Todo todo = new Todo(inputStr);
        toDoListMap.put(idCnt, todo);
        return idCnt++;
    }

    public int doneToDoList(int input) {
        Todo todo = toDoListMap.get(input);

        if(todo==null) throw new RuntimeException("해당 ID의 할 일이 없습니다.");

        if(todo.getStatus().isTodo()){
            toDoListMap.get(input).done();
        }else if(todo.getStatus().isDone()){
            throw new RuntimeException("이미 완료한 할 일입니다.");
        }

        return input;
    }


    public int removeToDoList(int input) {
        if(!toDoListMap.containsKey(input)) throw new RuntimeException("해당 ID의 할 일이 없습니다.");

        toDoListMap.remove(input);
        return input;
    }

    public ArrayList<Integer> getKeyArray(){
        return new ArrayList<>(toDoListMap.keySet());
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


    public boolean hasTodo(int input) {
        return toDoListMap.containsKey(input);
    }

    public Todo getTodo(int input) {
        return toDoListMap.get(input);
    }

    public ArrayList<Integer> search(String keyword) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int key : toDoListMap.keySet()){
            if(toDoListMap.get(key).isContainKeyword(keyword)){
                result.add(key);
            }
        }

        return result;
    }

}

