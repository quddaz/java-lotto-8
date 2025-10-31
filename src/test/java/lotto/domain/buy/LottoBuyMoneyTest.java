package lotto.domain.buy;

import lotto.exception.LottoDomainException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyMoneyTest {
    @Test
    @DisplayName("로또 구매 금액에 따른 로또 개수 계산 테스트")
    void testLottoCountCalculation() {
        //given
        LottoBuyMoney lottoBuyMoney = new LottoBuyMoney("5000");

        //when
        int lottoCount = lottoBuyMoney.getLottoCount();

        //then
        assertThat(lottoCount).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 구매 금액이 0원일 때 로또 개수 계산 테스트")
    void testLottoCountCalculationZeroAmount() {
        //given & when & then
        assertThatThrownBy(() -> new LottoBuyMoney("0")).isInstanceOf(LottoDomainException.class);
    }

    @Test
    @DisplayName("로또 구매 금액이 숫자가 아닐 때 로또 개수 계산 테스트")
    void testLottoCountCalculationNonNumeric() {
        //given & when & then
        assertThatThrownBy(() -> new LottoBuyMoney("abc")).isInstanceOf(LottoDomainException.class);
    }

    @Test
    @DisplayName("로또 구매 금액이 1000원 배수가 아닐때  로또 개수 계산 테스트")
    void testLottoCountCalculationNegativeAmount() {
        //given & when & then
        assertThatThrownBy(() -> new LottoBuyMoney("1500")).isInstanceOf(LottoDomainException.class);
    }
}
