package org.homework;

enum OptionEnum {
    ADD("1"), DONE("2"), DELETE("3"), VIEW("4"),
    VIEWALL("5"), VIEWSORT("6"), SEARCH("7"), EXIT("8");

    private final String input;
    OptionEnum(String input) {
        this.input = input;
    }


    public static OptionEnum of(String input) {

        for(OptionEnum value : OptionEnum.values()){
            if(value.input.equals(input)){
                return value;
            }
        }

        throw new RuntimeException("잘못된 입력입니다.");
    }
}
