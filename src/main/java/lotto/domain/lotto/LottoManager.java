package lotto.domain.lotto;

import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoResult;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {

    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<Lotto> lottos;
    private static final String DELIMITER = "\n";
    public LottoManager(int count, LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = new ArrayList<>();
        this.lottoNumberGenerator = lottoNumberGenerator;
        setUpLottos(count);

    }

    public void setUpLottos(int count) {
        for(int i = 0; i < count; i++)
            this.lottos.add(new Lotto(lottoNumberGenerator.generate()));
    }

    public int size() {
        return lottos.size();
    }

    public String lottoNumber() {
        return lottos.stream()
            .map(Lotto::getNumbersAsString)
            .collect(Collectors.joining(DELIMITER));
    }

    public LottoResult getPrizeCount(List<Integer> prizeNumbers, int bonusNumber) {

        EnumMap<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }


        for (Lotto lotto : lottos) {
            Rank rank = lotto.getMatchRank(prizeNumbers, bonusNumber);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return new LottoResult(rankCount.entrySet().stream()
            .map(entry -> new lotto.domain.dto.RankCountDto(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList()));
    }
}
