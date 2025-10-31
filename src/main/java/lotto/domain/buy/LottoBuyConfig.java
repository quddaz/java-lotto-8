package lotto.domain.buy;

public enum LottoBuyConfig {
    LOTTO_PRICE(1000);

    private final int value;

    LottoBuyConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isValidLottoBuyAmount(int amount) {
        return amount > 0 && amount % LOTTO_PRICE.getValue() == 0;
    }

}
