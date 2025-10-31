package lotto.domain.lotto;

import lotto.exception.DomainExceptionMessage;
import lotto.exception.LottoDomainException;
import lotto.validator.WinningLottoNumberValidator;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private static final String DEFAULT_PATTERN = ",";

    private WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    //팩토리 메소드
    public static WinningLotto createFrom(String input, String bonusInput) {
        try {
            List<Integer> winningNumbers = Arrays.stream(input.split(DEFAULT_PATTERN))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .toList();

            int bonusNumber = Integer.parseInt(bonusInput);

            WinningLottoNumberValidator.validateWinningNumbers(winningNumbers);
            WinningLottoNumberValidator.validateBonusNumber(bonusNumber, winningNumbers);

            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (NumberFormatException e) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public LottoRank findMatchRank(Lotto lotto) {
        int matchCount = lotto.getMatchCountRank(winningLotto);
        boolean isBonusMatch = lotto.isMatchBonusNumber(bonusNumber);
        return LottoRank.findRank(matchCount, isBonusMatch);
    }
}
