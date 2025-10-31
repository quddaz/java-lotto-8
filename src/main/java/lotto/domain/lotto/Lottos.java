package lotto.domain.lotto;

import lotto.domain.lotto.config.LottoPatternConfig;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<Lotto> lottos;

    public Lottos(int count, LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = new ArrayList<>();
        this.lottoNumberGenerator = lottoNumberGenerator;
        generateLottos(count);

    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++)
            this.lottos.add(new Lotto(lottoNumberGenerator.generate()));
    }

    public String lottoNumber() {
        return lottos.stream()
            .map(Lotto::getNumbersAsString)
            .collect(Collectors.joining(LottoPatternConfig.LINE_DELIMITER.get()));
    }

    public List<LottoRank> getLottoRanks(WinningLotto winningLotto) {
        return lottos.stream()
            .map(winningLotto::findMatchRank).toList();
    }

}
