package lotto.domain;

public class LottoMoney {
    private final int amount;
    private static final int LOTTO_PRICE = 1000;

    public LottoMoney(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }

        if(amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 양수여야 합니다.");
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

}
