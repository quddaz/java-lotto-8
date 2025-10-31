package lotto.domain.lotto;


import lotto.domain.dto.RankCountDto;

import java.util.Comparator;
import java.util.List;

public class LottoResult {
    private final List<RankCountDto> rankCountDtos;
    private final int totalPrize;

    public LottoResult(List<RankCountDto> rankCountDtos) {
        this.rankCountDtos = filterAndSort(rankCountDtos);
        this.totalPrize = calculateTotalPrize(this.rankCountDtos);
    }

    private List<RankCountDto> filterAndSort(List<RankCountDto> dtos) {
        return dtos.stream()
            .filter(dto -> dto.rank() != LottoRank.MISS)
            .sorted(Comparator.comparingInt(dto -> dto.rank().getMatchCount()))
            .toList();
    }

    private int calculateTotalPrize(List<RankCountDto> dtos) {
        return dtos.stream()
            .mapToInt(dto -> dto.rank().getPrizeMoney() * dto.count())
            .sum();
    }

    public List<RankCountDto> getRankCountDtos() { return rankCountDtos; }
    public int getTotalPrize() { return totalPrize; }
}
