package org.homework.constant;

import java.util.Arrays;

public enum SortOptionEnum {

    DESC("1"), ASC("2");

    private final String input;
    SortOptionEnum(String input) {
        this.input = input;
    }


    public static SortOptionEnum of(String input) {
        return Arrays.stream(SortOptionEnum.values())
                .filter(value -> value.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("잘못된 입력입니다."));
    }
}
