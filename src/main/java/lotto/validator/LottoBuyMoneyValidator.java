package lotto.validator;

import lotto.domain.buy.LottoBuyConfig;
import lotto.exception.DomainExceptionMessage;
import lotto.exception.LottoDomainException;

public class LottoBuyMoneyValidator {
    private LottoBuyMoneyValidator(){
    }

    public static int validateAmount(String input) {
        int amount = parseAmount(input);
        validLottoBuyAmount(amount);
        return amount;
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_PARSEABLE_NUMBER);
        }
    }

    private static void validLottoBuyAmount(int amount) {
        if (!LottoBuyConfig.isValidLottoBuyAmount(amount)) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_PURCHASE_AMOUNT);
        }
    }
}
