package org.homework.view;

import org.homework.constant.OptionEnum;
import org.homework.constant.SortOptionEnum;
import org.homework.constant.StatusSelectOptionEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public OptionEnum getUserAction() throws IOException {
        return OptionEnum.of(br.readLine());
    }

    public String getTodoDetails() throws IOException {
        String inputStr = br.readLine();
        if(inputStr.trim().length()==0) throw new RuntimeException("내용을 입력해주세요.");
        return inputStr;
    }

    public int getInputNumber() throws IOException {
        return isNumber(br.readLine());
    }

    public SortOptionEnum getSortOption() throws IOException {
        return SortOptionEnum.of(br.readLine());
    }

    public StatusSelectOptionEnum getStatusOption() throws IOException{
        return StatusSelectOptionEnum.of(br.readLine());
    }

    public String getSearchKeyword() throws IOException {
        //추가 로직
        return br.readLine();
    }

    private int isNumber(String inputData){
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다.");
        }
    }




}
