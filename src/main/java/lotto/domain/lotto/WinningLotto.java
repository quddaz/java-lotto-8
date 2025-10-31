package lotto.domain.lotto;

import lotto.domain.lotto.config.LottoPatternConfig;
import lotto.exception.DomainExceptionMessage;
import lotto.exception.LottoDomainException;
import lotto.validator.WinningLottoNumberValidator;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    //팩토리 메소드
    public static WinningLotto createFrom(String input, String bonusInput) {
        try {
            List<Integer> winningNumbers = parseWinningNumbers(input);
            int bonusNumber = Integer.parseInt(bonusInput);

            WinningLottoNumberValidator.validateWinningNumbers(winningNumbers);
            WinningLottoNumberValidator.validateBonusNumber(bonusNumber, winningNumbers);

            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (NumberFormatException e) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_NUMBER_FORMAT);
        }
    }
    private static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(LottoPatternConfig.DEFAULT_DELIMITER.get()))
            .map(String::trim)
            .map(Integer::parseInt)
            .sorted()
            .toList();
    }

    public LottoRank findMatchRank(Lotto lotto) {
        int matchCount = lotto.getMatchCountRank(winningLotto);
        boolean isBonusMatch = lotto.isMatchBonusNumber(bonusNumber);
        return LottoRank.findRank(matchCount, isBonusMatch);
    }
}
