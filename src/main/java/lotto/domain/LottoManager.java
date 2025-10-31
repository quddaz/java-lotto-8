package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public String lottoNumber(String delimiter) {
        return lottos.stream()
            .map(Lotto::getNumbersAsString)
            .collect(Collectors.joining(delimiter));
    }
}
