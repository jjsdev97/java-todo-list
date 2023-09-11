package org.homework;

enum StatusSelectOptionEnum {

    TODO("1"), DOING("2"), DONE("3");

    private final String input;
    StatusSelectOptionEnum(String input) {
        this.input = input;
    }


    public static StatusSelectOptionEnum of(String input) {

        for(StatusSelectOptionEnum value : StatusSelectOptionEnum.values()){
            if(value.input.equals(input)){
                return value;
            }
        }

        throw new RuntimeException("잘못된 입력입니다.");
    }
}
