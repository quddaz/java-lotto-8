package lotto.validator;

import lotto.domain.lotto.config.LottoConfig;
import lotto.exception.DomainExceptionMessage;
import lotto.exception.LottoDomainException;

import java.util.List;
import java.util.Set;

public class LottoValidator {
    private LottoValidator() {}

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }
    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new LottoDomainException(DomainExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.NUMBER_LENGTH.getValue()) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_LOTTO_NUMBER_SIZE);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        numbers.stream()
            .filter(n -> !LottoConfig.isValidLottoNumber(n))
            .findFirst()
            .ifPresent(n -> {
                throw new LottoDomainException(DomainExceptionMessage.INVALID_LOTTO_NUMBER);
            });
    }
}
