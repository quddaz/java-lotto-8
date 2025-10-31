package lotto.domain.lotto;

import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public String getNumbersAsString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }

    public Rank getMatchRank(List<Integer> prizeNumbers, int bonusNumber) {
        long matchCount = numbers.stream()
            .filter(prizeNumbers::contains)
            .count();

        boolean bonusMatch = numbers.contains(bonusNumber);

        if (matchCount == 6) return Rank.FIRST;
        if (matchCount == 5 && bonusMatch) return Rank.SECOND;
        if (matchCount == 5) return Rank.THIRD;
        if (matchCount == 4) return Rank.FOURTH;
        if (matchCount == 3) return Rank.FIFTH;

        return Rank.MISS;
    }
}
