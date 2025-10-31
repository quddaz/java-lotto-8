package lotto.domain.lotto;

import lotto.domain.lotto.config.LottoPatternConfig;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }


    public String getNumbersAsString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(LottoPatternConfig.DEFAULT_DELIMITER.get()
                , LottoPatternConfig.FORMAT_PREFIX.get()
                , LottoPatternConfig.FORMAT_SUFFIX.get()));
    }

    public int getMatchCountRank(Lotto winningLotto) {
        return (int) numbers.stream()
            .filter(winningLotto.numbers::contains)
            .count();
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
