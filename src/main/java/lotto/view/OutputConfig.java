package lotto.view;

public enum OutputConfig {
    PURCHASE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_MESSAGE("%d개를 구매했습니다.\n"),
    PRIZE_LOTTO_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    STATISTICS_HEADER("당첨 통계\n---\n"),
    PROFIT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String format;

    OutputConfig(String format) {
        this.format = format;
    }

    public String get() {
        return format;
    }
}