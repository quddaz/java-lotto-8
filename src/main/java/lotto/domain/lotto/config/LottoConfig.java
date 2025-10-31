package lotto.domain.lotto.config;

public enum LottoConfig {
    NUMBER_LENGTH(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isValidLottoNumber(int number) {
        return number >= MIN_NUMBER.getValue() && number <= MAX_NUMBER.getValue();
    }

}
