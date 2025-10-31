package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    @DisplayName("LottoRank의 매치 수와 보너스 매치에 따른 등수 및 당첨 금액이 올바른지 테스트")
    void 로또_등수_및_당첨금액_테스트() {
        // given & when & then
        assertThat(LottoRank.findRank(0, false)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.findRank(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.findRank(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.findRank(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.findRank(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findRank(6, false)).isEqualTo(LottoRank.FIRST);
    }
}
