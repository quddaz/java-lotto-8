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
    }

    private void calculateResults(Lottos lottos, WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = lottos.getLottoRanks(winningLotto);

        for (LottoRank rank : lottoRanks) {
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }
    }

    public double calculateReward() {
        long totalReward = 0;
        for(EnumMap.Entry<LottoRank, Integer> entry : rankCountMap.entrySet()){
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalReward += rank.getWinningMoney() * count;
        }
        return ((double) totalReward / (getLottoCount() * LottoBuyConfig.LOTTO_PRICE.getValue())) * 100;
    }

    private int getLottoCount(){
        return rankCountMap.values().stream().mapToInt(Integer::intValue).sum();
    }

}

