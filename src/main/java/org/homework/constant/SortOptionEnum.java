package org.homework.constant;

public enum SortOptionEnum {

    DESC("1"), ASC("2");

    private final String input;
    SortOptionEnum(String input) {
        this.input = input;
    }


    public static SortOptionEnum of(String input) {

        for(SortOptionEnum value : SortOptionEnum.values()){
            if(value.input.equals(input)){
                return value;
            }
        }

        throw new RuntimeException("잘못된 입력입니다.");
    }
}
