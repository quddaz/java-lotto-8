package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


// DIP 적용한 LottoNumberGenerator 구현체
public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private final int LOTTO_NUMBER_COUNT;
    private final int LOTTO_NUMBER_MIN;
    private final int LOTTO_NUMBER_MAX;

    public RandomLottoNumberGenerator(int lottoNumberCount, int lottoNumberMin, int lottoNumberMax) {
        this.LOTTO_NUMBER_COUNT = lottoNumberCount;
        this.LOTTO_NUMBER_MIN = lottoNumberMin;
        this.LOTTO_NUMBER_MAX = lottoNumberMax;
    }

    @Override
    public List<Integer> generate() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
            LOTTO_NUMBER_MIN,
            LOTTO_NUMBER_MAX,
            LOTTO_NUMBER_COUNT
        ));
        Collections.sort(lotto);
        return lotto;
    }

}
