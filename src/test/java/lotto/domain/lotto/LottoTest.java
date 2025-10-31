package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_아니라면_예외가_발생한다() {
        // given
        List<Integer> tooManyNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> tooFewNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(tooManyNumbers))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(tooFewNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(duplicatedNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void 로또_번호가_1_45_범위를_벗어나면_예외가_발생한다() {
        // given
        List<Integer> belowRange = List.of(0, 2, 3, 4, 5, 6);
        List<Integer> aboveRange = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(belowRange))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(aboveRange))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 생성 시 정렬되어 출력되어야 한다.")
    void 로또_번호_출력_로직_테스트() {
        // given
        List<Integer> numbers = List.of(10, 1, 5, 3, 7, 2);
        Lotto lotto = new Lotto(numbers);
        String expected = "[1, 2, 3, 5, 7, 10]";

        // when
        String actual = lotto.getNumbersAsString();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호 일치 개수 확인 테스트")
    void 로또_번호_일치_개수_확인_테스트() {
        // given
        Lotto winningLotto = new Lotto(List.of(3, 11, 15, 29, 35, 44));
        Lotto lotto = new Lotto(List.of(1, 3, 5, 11, 29, 41));

        // when
        int matchCount = lotto.getMatchCountRank(winningLotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호 일치 확인 테스트")
    void 보너스_번호_일치_확인_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 11, 29, 41));
        int bonusNumberMatch = 41;
        int bonusNumberNoMatch = 7;

        // when
        boolean isMatch = lotto.isMatchBonusNumber(bonusNumberMatch);
        boolean isNoMatch = lotto.isMatchBonusNumber(bonusNumberNoMatch);

        // then
        assertThat(isMatch).isTrue();
        assertThat(isNoMatch).isFalse();
    }

}
