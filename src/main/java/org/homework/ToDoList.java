package org.homework;

import java.util.HashMap;

public class ToDoList {
    private int idCnt = 1;
    private HashMap<Integer, String> hm = new HashMap<>();


    public void addTDL(String str) {
        hm.put(idCnt, str);

        System.out.printf("할 일이 추가되었습니다. ID: %d\n", idCnt);

        idCnt++;
    }

    public void removeTDL(String str) {
        int id = 0;
        try {
            id = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        if (hm.remove(id) == null) {
            System.out.println("해당 ID의 할 일이 없습니다.");
        } else {
            System.out.printf("할 일이 삭제되었습니다. ID: %d", id);
        }

    }

    public void selectTDL(String str) {
        int id = 0;

        try {
            id = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        String result = hm.get(id);
        if(result!=null){
            System.out.printf("할 일 ID: %d 내용: %s\n", id, result);
        }else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }

    }
}

