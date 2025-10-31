package lotto.controller;

import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;



public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;
    public LottoController(InputView inputView, OutputView outputView,
                           LottoNumberGenerator lottoNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
    }
}
