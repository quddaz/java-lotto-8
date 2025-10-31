package lotto.domain;


import lotto.domain.buy.LottoBuyConfig;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;

import java.util.EnumMap;
import java.util.List;


public class LottoResult {
    private final EnumMap<LottoRank, Integer> rankCountMap;

    public LottoResult(Lottos lottos, WinningLotto winningLotto) {
        this.rankCountMap = new EnumMap<>(LottoRank.class);
        calculateResults(lottos, winningLotto);
        rankCountMap.remove(LottoRank.MISS);
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
        return  (double) totalReward / (totalLottoCount * LottoBuyConfig.LOTTO_PRICE.getValue()) * 100;
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
}

