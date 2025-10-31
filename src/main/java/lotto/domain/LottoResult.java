package lotto.domain;


import lotto.domain.buy.LottoBuyConfig;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LottoResult {
    private final Map<LottoRank, Integer> rankCountMap;

    public LottoResult(Lottos lottos, WinningLotto winningLotto) {
        this.rankCountMap = new HashMap<>();
        generateEmptyRankMap();
        calculateResults(lottos, winningLotto);
    }

    private void generateEmptyRankMap() {
        for (LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    private void calculateResults(Lottos lottos, WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = lottos.getLottoRanks(winningLotto);

        for (LottoRank rank : lottoRanks) {
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }
    }

    public double calculateReward() {
        long totalReward = getTotalWinningMoney();
        int totalLottoCount = getTotalLottoCount();
        if (totalLottoCount == 0) {
            return 0.0;
        }
        return (double) totalReward / (totalLottoCount * LottoBuyConfig.LOTTO_PRICE.getValue()) * 100;
    }

    private long getTotalWinningMoney() {
        return rankCountMap.entrySet().stream()
            .mapToLong(e -> e.getKey().getWinningMoney() * e.getValue())
            .sum();
    }

    private int getTotalLottoCount() {
        return rankCountMap.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public String getResultString() {
        StringBuilder resultBuilder = new StringBuilder();
        rankCountMap.keySet().stream()
            .filter(rank -> rank != LottoRank.MISS)
            .sorted((r1, r2) -> Integer.compare(r1.getMatchCount(), r2.getMatchCount()))
            .forEach(rank -> {
                String formattedResult = String.format(rank.getMatchFormat(), rankCountMap.get(rank));
                resultBuilder.append(formattedResult).append("\n");
            });
        return resultBuilder.toString();
    }
}

