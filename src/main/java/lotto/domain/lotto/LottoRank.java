package lotto.domain.lotto;

public enum LottoRank {
    MISS(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) -"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) -"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) -"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) -");

    private final int matchCount;
    private final int prizeMoney;
    private final String matchFormat;

    LottoRank(int matchCount, int prizeMoney, String matchFormat) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchFormat = matchFormat;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMatchFormat() {
        return matchFormat;
    }

}
