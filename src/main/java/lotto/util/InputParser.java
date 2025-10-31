package lotto.util;

import java.util.Arrays;

public class InputParser {
    private static final String DEFAULT_PATTERN = ",";

    public int[] parseToIntArray(String input) {
        return Arrays.stream(input.split(DEFAULT_PATTERN))
            .map(String::trim)
            .mapToInt(this::parseToInt)
            .map(this::validateNumberFormat)
            .toArray();
    }

    private int validateNumberFormat(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 올바르지 않습니다.");
        }
        return input;
    }

    public int parseToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 올바르지 않습니다.");
        }

        return number;
    }
}
