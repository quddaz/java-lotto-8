package lotto.domain.dto;

import lotto.domain.LottoRank;

public record RankCountDto(LottoRank rank, int count) {
    public String getMatchFormat() {
        return rank.getMatchFormat();
    }
}
