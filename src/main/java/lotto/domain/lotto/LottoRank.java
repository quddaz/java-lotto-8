package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0, false, ""),
    FIFTH(3, 5_000, false, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000, false, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000, false, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000, false, "6개 일치 (2,000,000,000원) - %d개");
    private final int matchCount;
    private final long winningMoney;
    private final boolean bonusMatch;
    private final String matchFormat;

    LottoRank(int matchCount, int winningMoney, boolean bonusMatch, String matchFormat) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.bonusMatch = bonusMatch;
        this.matchFormat = matchFormat;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public String getMatchFormat() {
        return matchFormat;
    }

    public static LottoRank findRank(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(values())
            .filter(rank -> rank.isMatched(matchCount, isBonusMatch))
            .findFirst()
            .orElse(MISS);
    }
    private boolean isMatched(int matchCount, boolean isBonusMatch) {
        if (this == SECOND) {
            return matchCount == this.matchCount && isBonusMatch;
        }
        return matchCount == this.matchCount;
    }
}
