package lotto.domain.dto;

import lotto.domain.Rank;

public record RankCountDto(Rank rank, int count) {
    public String getMatchFormat() {
        return rank.getMatchFormat();
    }
}
