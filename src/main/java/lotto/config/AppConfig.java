package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.util.InputParser;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final InputParser inputParser;

    private final LottoMachine lottoMachine;
    private final LottoController lottoController;

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoNumberGenerator = new RandomLottoNumberGenerator(LOTTO_NUMBER_COUNT, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
        this.inputParser = new InputParser();
        this.lottoMachine = new LottoMachine(lottoNumberGenerator);
        this.lottoController = new LottoController(inputView, outputView, lottoMachine, inputParser);
    }

    public LottoController getLottoController() {
        return lottoController;
    }

}
