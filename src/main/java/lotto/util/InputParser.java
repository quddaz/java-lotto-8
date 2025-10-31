package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DEFAULT_PATTERN = ",";

    public List<Integer> parseToLottoNumbers(String input) {
        return Arrays.stream(input.split(DEFAULT_PATTERN))
            .map(String::trim)
            .mapToInt(this::parseToInt)
            .map(this::validateNumberFormat)
            .sorted()
            .boxed()
            .toList();
    }
    // 숫자 범위 검증
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
