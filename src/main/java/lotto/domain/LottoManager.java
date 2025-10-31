package lotto.domain;

import lotto.domain.lotto.Lottos;

public class LottoManager {
    private final Lottos lottos;
    private final int purchaseCount;
    private static final String DEFAULT_DELIMITER = "\n";
    public LottoManager(Lottos lottos, int purchaseCount) {
        this.lottos = lottos;
        this.purchaseCount = purchaseCount;
    }

    public String lottoNumber() {
        return lottos.lottoNumber(DEFAULT_DELIMITER);
    }

}
