package com.medianet.kata.stringcalculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final int LIMIT_NUMBER = 1000;
    private static final String START_DELIMITER_CODE = "//";
    private static final String END_DELIMITER_CODE = "\n";
    private static final String DEFAULT_CHARACTER_SPLIT = ",";

    private String delimiter;
    private String numbers;

    public int add(final String rawNumbers) {
        obtainNumbers(rawNumbers);
        if (numbers.isEmpty()) {
            return 0;
        }
        return sumNumbers();
    }

    private void obtainNumbers(String rawNumbers) {
        if(containDelimiter(rawNumbers))
        {
            delimiter = rawNumbers.substring(2,rawNumbers.indexOf(END_DELIMITER_CODE));
            numbers = rawNumbers.substring(rawNumbers.indexOf(END_DELIMITER_CODE)+1);
            return;
        } 
        delimiter = DEFAULT_CHARACTER_SPLIT;
        numbers = rawNumbers;
    }

    private boolean containDelimiter(String rawNumbers) {
        return rawNumbers.startsWith(START_DELIMITER_CODE)&& rawNumbers.contains(END_DELIMITER_CODE);
    }

    private Integer sumNumbers() {
        List<Integer> numbersInteger = new ArrayList<>();
        splitNumbers(numbers).forEach(number -> numbersInteger.add(Integer.valueOf(number.trim())));
        return numbersInteger.stream().filter((n) -> n < LIMIT_NUMBER).mapToInt(number -> number).sum();
    }

    private List<String> splitNumbers(String numbers) {
        return Arrays.asList(numbers.split(delimiter));
    }
}
