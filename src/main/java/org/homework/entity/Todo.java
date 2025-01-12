package org.homework.entity;

import org.homework.constant.StatusEnum;

public class Todo {
    private int id;
    private String content;
    private StatusEnum status = StatusEnum.TODO; // TODO, DOING, DONE,

    public Todo(int id, String inputStr) {
        this.id = id;
        this.content = inputStr;
    }

    public boolean isContainKeyword(String keyword) {
        return content.contains(keyword);
    }

    public void todo(){
        this.status = StatusEnum.TODO;
    }

    public void done(){
        this.status = StatusEnum.DONE;
    }
    public void doing(){
        this.status = StatusEnum.DOING;
    }

    public boolean isDone(){
        return status.isDone();
    }

    public boolean isTodo(){
        return status.isTodo();
    }

    public boolean isDoing() {
        return status.isDoing();
    }

    public int getId(){
        return id;
    }
    @Override
    public String toString() {
        return String.format("할 일 ID: %d , 내용: %s %s", id, content, status.getStatusStr());
    }

}
