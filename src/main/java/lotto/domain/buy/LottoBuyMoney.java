package lotto.domain.buy;


import lotto.validator.LottoBuyMoneyValidator;

public class LottoBuyMoney {
    private final int amount;


    public LottoBuyMoney(int amount) {
        LottoBuyMoneyValidator.validateAmount(amount);
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / LottoBuyConfig.LOTTO_PRICE.getValue();
    }
}
