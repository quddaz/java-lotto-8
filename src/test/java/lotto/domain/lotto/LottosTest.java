package lotto.domain.lotto;


import lotto.domain.lotto.config.LottoPatternConfig;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lottos 생성 시 count 개수만큼 로또가 생성된다.")
    void 로또_개수_생성_테스트() {
        // given
        int count = 5;
        LottoNumberGenerator generator = () -> List.of(1, 2, 3, 4, 5, 6);

        // when
        Lottos lottos = new Lottos(count, generator);

        // then
        String[] lines = lottos.getStringlottosNumber().split(LottoPatternConfig.LINE_DELIMITER.get());
        assertThat(lines.length).isEqualTo(count);
    }

    @Test
    @DisplayName("Lottos 번호 출력이 올바른 형식으로 나오는지 테스트")
    void 로또_번호_출력_형식_테스트() {
        // given
        int count = 2;
        LottoNumberGenerator generator = () -> List.of(10, 1, 5, 3, 7, 2);

        // when
        Lottos lottos = new Lottos(count, generator);

        // then
        String expected = "[1, 2, 3, 5, 7, 10]" + LottoPatternConfig.LINE_DELIMITER.get() + "[1, 2, 3, 5, 7, 10]";
        assertThat(lottos.getStringlottosNumber()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WinningLotto와 비교 시 LottoRank가 정상적으로 계산된다.")
    void 로또_등수_계산_테스트() {
        // given
        LottoNumberGenerator generator = () -> List.of(1, 2, 3, 4, 5, 6);
        Lottos lottos = new Lottos(1, generator);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        List<LottoRank> ranks = lottos.getLottoRanks(winningLotto);

        // then
        assertThat(ranks).hasSize(1);
        assertThat(ranks.get(0).getMatchCount()).isEqualTo(6); // 6개 맞으면 1등 가정
        assertThat(ranks.get(0).isBonusMatch()).isFalse();           // 보너스 번호는 아님
    }
}
