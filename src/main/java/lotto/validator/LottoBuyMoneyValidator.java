package lotto.validator;

import lotto.domain.buy.LottoBuyConfig;

public class LottoBuyMoneyValidator {
    private LottoBuyMoneyValidator(){
    }

    public static void validateAmount(int amount) {
        if (!LottoBuyConfig.isValidLottoBuyAmount(amount)) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
