package org.homework;

enum StatusEnum {
    TODO(""), DOING("[진행중]"), DONE("[완료]");

    private final String status;
    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatusStr(){
        return status;
    }

    public boolean isTodo() {
        return this == TODO;
    }

    public boolean isDone() {
        return this == DONE;
    }

    public boolean isDoing() {
        return this == DOING;
    }






}
