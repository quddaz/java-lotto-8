package lotto.domain.dto;

import lotto.domain.lotto.LottoRank;

public record RankCountDto(LottoRank rank, int count) {
    public String getMatchFormat() {
        return rank.getMatchFormat();
    }
}
