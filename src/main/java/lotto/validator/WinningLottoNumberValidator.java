package lotto.validator;

import lotto.domain.lotto.config.LottoConfig;
import lotto.exception.DomainExceptionMessage;
import lotto.exception.LottoDomainException;

import java.util.List;
import java.util.Set;

public class WinningLottoNumberValidator {

    private WinningLottoNumberValidator() {
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers);
        validateDuplicate(winningNumbers);
        validateRange(winningNumbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusRange(bonusNumber);
        validateBonusNotDuplicated(bonusNumber, winningNumbers);
    }

    private static void validateLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConfig.NUMBER_LENGTH.getValue()) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_WINNING_NUMBER_SIZE);
        }
    }

    private static void validateDuplicate(List<Integer> winningNumbers) {
        Set<Integer> numberSet = Set.copyOf(winningNumbers);
        if (winningNumbers.size() != numberSet.size()) {
            throw new LottoDomainException(DomainExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private static void validateRange(List<Integer> winningNumbers) {
        winningNumbers.stream()
            .filter(n -> !LottoConfig.isValidLottoNumber(n))
            .findFirst()
            .ifPresent(n -> {
                throw new LottoDomainException(DomainExceptionMessage.INVALID_LOTTO_NUMBER);
            });
    }

    private static void validateBonusRange(int bonusNumber) {
        if (!LottoConfig.isValidLottoNumber(bonusNumber)) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_LOTTO_NUMBER);
        }
    }

    private static void validateBonusNotDuplicated(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoDomainException(DomainExceptionMessage.DUPLICATE_BONUS_NUMBER);
        }
    }
}