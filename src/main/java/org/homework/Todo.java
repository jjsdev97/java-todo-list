package org.homework;

public class Todo {
    private String content;
    private boolean status = false;

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

    public boolean isStatus() {
        return status;
    }

    public void changeStatus() {
        status = !status;
    }
}
