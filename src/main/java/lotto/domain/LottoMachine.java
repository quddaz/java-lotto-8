package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoNumberGenerator generator;

    public LottoMachine(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generator.generate()));
        }
        return new Lottos(lottos);
    }
}
