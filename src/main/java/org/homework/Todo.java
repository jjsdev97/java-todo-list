package org.homework;

public class Todo {
    private String content;
    private StatusEnum status = StatusEnum.TODO; // TODO, DOING, DONE,

    public Todo(String inputStr) {
        this.content = inputStr;
    }

    public String getContent() {
        return content;
    }

    public boolean isContainKeyword(String keyword) {
        return content.contains(keyword);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isTodo() {
        return status.name().equals("TODO");
    }
    public void todo(){
        this.status = StatusEnum.TODO;
    }

    public boolean isDone() {
        return this.status.name().equals("DONE");
    }

    public void done(){
        this.status = StatusEnum.DONE;
    }

    public boolean isDoing() {
        return this.status.name().equals("DOING");
    }

    public void doing(){
        this.status = StatusEnum.DOING;
    }

    public String getStatus(){
        return status.getStatus();
    }


}
