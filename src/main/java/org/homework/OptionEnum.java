package org.homework;

enum OptionEnum {
    ADD("1"), DELETE("2"), VIEW("3"), EXIT("4");
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
