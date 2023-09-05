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

    public void todo(){
        this.status = StatusEnum.TODO;
    }

    public void done(){
        this.status = StatusEnum.DONE;
    }

    public void doing(){
        this.status = StatusEnum.DOING;
    }

    public StatusEnum getStatus(){
        return status;
    }


}
