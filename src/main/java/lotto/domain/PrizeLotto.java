package lotto.domain;

import java.util.List;

public class PrizeLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public PrizeLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = List.copyOf(numbers);
        this.bonusNumber = bonusNumber;
    }
    
}
