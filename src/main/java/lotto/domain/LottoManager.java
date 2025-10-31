package lotto.domain;

public class LottoManager {
    private final Lottos lottos;
    private static final String DEFAULT_DELIMITER = "\n";
    public LottoManager(Lottos lottos) {
        this.lottos = lottos;
    }

    public String lottoNumber() {
        return lottos.lottoNumber(DEFAULT_DELIMITER);
    }


}
