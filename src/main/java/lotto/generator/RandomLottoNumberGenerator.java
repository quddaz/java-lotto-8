package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.config.LottoConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// DIP 적용한 LottoNumberGenerator 구현체
public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    public RandomLottoNumberGenerator() {
    }

    @Override
    public List<Integer> generate() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
            LottoConfig.MIN_NUMBER.getValue(),
            LottoConfig.MAX_NUMBER.getValue(),
            LottoConfig.NUMBER_LENGTH.getValue()
        ));
        Collections.sort(lotto);
        return lotto;
    }
}
