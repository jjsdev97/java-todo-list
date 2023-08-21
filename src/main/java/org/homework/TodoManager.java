package org.homework;

import java.util.HashMap;

public class TodoManager {
    private int idCnt = 1;
    private HashMap<Integer, String> toDoListMap = new HashMap<>();


    public int addTDL(String str) {
        return (toDoListMap.put(idCnt, str)==null) ? idCnt++ : -1;
    }

    public int removeTDL(String str) {
        int id = isNumber(str);
        if(id == -1) return -1;

        return (toDoListMap.remove(id) == null) ? 0 : id;

    }

    public String selectTDL(String str) {
        String result = null;
        int id = isNumber(str);
        if(id == -1) return null;

        if(toDoListMap.containsKey(id)){
            result = String.format("할 일 ID: %d | 내용: %s\n", id, toDoListMap.get(id));
        }else {
            result = "해당 ID의 할 일이 없습니다.";
        }

        return result;
    }

    public int isNumber(String inputData){
        int id = 0;

        try {
            id = Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            return -1;
        }

        return id;
    }
}

