package lotto.domain.lotto;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank findMatchRank(Lotto lotto) {
        int matchCount = lotto.getMatchCountRank(winningLotto);
        boolean isBonusMatch = lotto.isMatchBonusNumber(bonusNumber);
        return LottoRank.findRank(matchCount, isBonusMatch);
    }
}
