package lotto.util;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


// DIP 적용한 LottoNumberGenerator 구현체
public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


}
