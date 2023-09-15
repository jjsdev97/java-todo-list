package org.homework.constant;

import java.util.Arrays;

public enum OptionEnum {
    ADD("1"), DONE("2"), DELETE("3"), VIEW("4"),
    VIEWALL("5"), VIEWSORT("6"), VIEWSTATUS("7"), SEARCH("8"), EXIT("9");

    private final String input;
    OptionEnum(String input) {
        this.input = input;
    }


    public static OptionEnum of(String input) {
        return Arrays.stream(OptionEnum.values())
                .filter(value -> value.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("잘못된 입력입니다."));
    }
}
