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



/*

    5. 최신순, 오래된순은 for문 반대로 쓰면 간단하게 가능? hashmap의 길이 조회하는 메소드?
    6. 키워드 검색 => for문으로 돌려서 contain으로 찾거나 해쉬맵의 메소드에 검색 관련한 메소드가 있는지 찾아보고 활용

    -- 정렬 어떻게 해야할지??
    1. 배열에 id값들을 다 넣어놓고 순서대로 출력하는 알고리즘??

*/
