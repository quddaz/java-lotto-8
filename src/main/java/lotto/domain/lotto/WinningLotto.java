package lotto.domain.lotto;

import lotto.domain.lotto.config.LottoPatternConfig;
import lotto.exception.DomainExceptionMessage;
import lotto.exception.LottoDomainException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(LottoPatternConfig.DEFAULT_WINNING_DELIMITER.get()))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int parseBonusNumber(String input) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new LottoDomainException(DomainExceptionMessage.INVALID_NUMBER_FORMAT);
        }
        return bonusNumber;
    }

    public LottoRank findMatchRank(Lotto lotto) {
        int matchCount = lotto.getMatchCountRank(winningLotto);
        boolean isBonusMatch = lotto.isMatchBonusNumber(bonusNumber);
        return LottoRank.findRank(matchCount, isBonusMatch);
    }
}
