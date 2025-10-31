package lotto.domain.buy;

public class LottoBuyMoney {
    private final int amount;


    public LottoBuyMoney(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (!LottoBuyConfig.isValidLottoBuyAmount(amount)) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public int getLottoCount() {
        return amount / LottoBuyConfig.LOTTO_PRICE.getValue();
    }
}
