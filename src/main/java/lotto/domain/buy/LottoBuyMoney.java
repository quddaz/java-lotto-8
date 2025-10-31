package lotto.domain.buy;


import lotto.validator.LottoBuyMoneyValidator;

public class LottoBuyMoney {
    private final int amount;

    public LottoBuyMoney(String input) {
        this.amount = LottoBuyMoneyValidator.validateAmount(input);
    }

    public int getLottoCount() {
        return amount / LottoBuyConfig.LOTTO_PRICE.getValue();
    }
}
