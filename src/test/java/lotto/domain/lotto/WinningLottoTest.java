package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("WinningLotto 생성 시 당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    void 당첨_번호_개수_예외_테스트() {
        // given
        List<Integer> manyNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> fewNumbers = List.of(1, 2, 3, 4, 5);
        int bonusNumber = 9;
        // when & then
        assertThatThrownBy(() -> new WinningLotto(manyNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto(fewNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("WinningLotto 생성 시 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 당첨_번호_중복_예외_테스트() {
        // given
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 9;
        // when & then
        assertThatThrownBy(() -> new WinningLotto(duplicatedNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("WinningLotto static 숫자형 리스트 반환 method 테스트")
    void 숫자형_리스트_반환_method_테스트() {
        // given
        String winningNumbersString = "10,20,30,40,41,42";

        // when
        List<Integer> winningNumbers = WinningLotto.parseWinningNumbers(winningNumbersString);

        // then
        assertThat(winningNumbers).containsExactly(10, 20, 30, 40, 41, 42);
    }

    @Test
    @DisplayName("WinningLotto 보너스 번호 반환 테스트")
    void 보너스_번호_반환_테스트() {
        // given
        String input = "7";
        String errorInput = "a";

        // when & then
        assertThat(WinningLotto.parseBonusNumber(input)).isEqualTo(7);
        assertThatThrownBy(() -> WinningLotto.parseBonusNumber(errorInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("WinningLotto 당첨 메소드 테스트")
    void 당첨_메소드_테스트() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 8, 9, 10)); // 3개 일치
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 + 보너스 일치
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개 일치

        // when & then
        assertThat(winningLotto.findMatchRank(lotto1)).isEqualTo(LottoRank.FIFTH);
        assertThat(winningLotto.findMatchRank(lotto2)).isEqualTo(LottoRank.SECOND);
        assertThat(winningLotto.findMatchRank(lotto3)).isEqualTo(LottoRank.FIRST);
    }
}
