package org.homework;

import java.util.HashMap;

public class TodoManager {
    private int idCnt = 1;
    private HashMap<Integer, String> toDoListMap = new HashMap<>();


    public void addTDL(String str) {
        toDoListMap.put(idCnt, str);

        System.out.printf("할 일이 추가되었습니다. ID: %d\n", idCnt);

        idCnt++;
    }

    public void removeTDL(String str) {

        int id = isNumber(str);

        if(id == -1) return;


        if (toDoListMap.remove(id) == null) {
            System.out.println("해당 ID의 할 일이 없습니다.");
        } else {
            System.out.printf("할 일이 삭제되었습니다. ID: %d\n", id);
        }

    }

    public void selectTDL(String str) {

        int id = isNumber(str);

        if(id == -1) return;

        if(toDoListMap.containsKey(id)){
            System.out.printf("할 일 ID: %d | 내용: %s\n", id, toDoListMap.get(id));
        }else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }

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

