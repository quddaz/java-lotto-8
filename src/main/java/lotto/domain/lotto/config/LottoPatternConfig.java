package lotto.domain.lotto.config;

public enum LottoPatternConfig {
    DEFAULT_DELIMITER(","),
    FORMAT_PREFIX("["),
    FORMAT_SUFFIX("]"),
    LINE_DELIMITER("\n");

    private final String value;

    LottoPatternConfig(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}