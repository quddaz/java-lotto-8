package lotto.config;

import lotto.LottoStarter;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoStarter lottoStarter;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoNumberGenerator = new RandomLottoNumberGenerator();
        this.lottoStarter = new LottoStarter(inputView, outputView, lottoNumberGenerator);
    }

    public LottoStarter getLottoStarter() {
        return lottoStarter;
    }

}
