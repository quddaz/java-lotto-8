package lotto.validator;

import lotto.exception.LottoDomainException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoValidatorTest {

    @Test
    @DisplayName("잘못된 길이의 로또 번호는 예외를 발생시킨다")
    void 잘못된_길이의_로또_번호_예외_발생_테스트() {
        // Given
        List<Integer> tooShort = List.of(1, 2, 3, 4, 5);
        List<Integer> tooLong = List.of(1, 2, 3, 4, 5, 6, 7);

        // When & Then
        assertThatThrownBy(() -> WinningLottoValidator.validateWinningNumbers(tooShort))
            .isInstanceOf(LottoDomainException.class);

        assertThatThrownBy(() -> WinningLottoValidator.validateWinningNumbers(tooLong))
            .isInstanceOf(LottoDomainException.class);
    }

    @Test
    @DisplayName("중복된 로또 번호는 예외를 발생시킨다")
    void 중복된_로또_번호_예외_테스트() {
        // Given
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);

        // When & Then
        assertThatThrownBy(() -> WinningLottoValidator.validateWinningNumbers(duplicateNumbers))
            .isInstanceOf(LottoDomainException.class);
    }

    @Test
    @DisplayName("로또 번호 범위를 벗어나면 예외를 발생시킨다")
    void 로또_번호_범위_벗어남_예외_테스트() {
        // Given
        List<Integer> tooLow = List.of(0, 2, 3, 4, 5, 6);
        List<Integer> tooHigh = List.of(1, 2, 3, 4, 5, 46);

        // When & Then
        assertThatThrownBy(() -> WinningLottoValidator.validateWinningNumbers(tooLow))
            .isInstanceOf(LottoDomainException.class);

        assertThatThrownBy(() -> WinningLottoValidator.validateWinningNumbers(tooHigh))
            .isInstanceOf(LottoDomainException.class);
    }

    @Test
    @DisplayName("범위를 벗어난 보너스 번호는 예외를 발생시킨다")
    void 보너스_번호_범위_벗어남_예외_테스트() {
        // Given
        int tooLowBonus = 0;
        int tooHighBonus = 46;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // When & Then
        assertThatThrownBy(() -> WinningLottoValidator.validateBonusNumber(tooLowBonus, winningNumbers))
            .isInstanceOf(LottoDomainException.class);

        assertThatThrownBy(() -> WinningLottoValidator.validateBonusNumber(tooHighBonus, winningNumbers))
            .isInstanceOf(LottoDomainException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다")
    void 보너스_번호_중복_예외_테스트() {
        // Given
        int bonusNumber = 5;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // When & Then
        assertThatThrownBy(() -> WinningLottoValidator.validateBonusNumber(bonusNumber, winningNumbers))
            .isInstanceOf(LottoDomainException.class);
    }

    @Test
    @DisplayName("올바른 로또 번호와 보너스 번호는 예외 없이 통과한다")
    void 올바른_로또_번호_보너스_번호_테스트() {
        // Given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // When & Then
        WinningLottoValidator.validateWinningNumbers(winningNumbers);
        WinningLottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
    }
}