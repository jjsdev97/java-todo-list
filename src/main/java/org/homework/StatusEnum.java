package org.homework;

enum StatusEnum {
    TODO(""), DOING("[진행중]"), DONE("[완료]");

    private final String status;
    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }


}
