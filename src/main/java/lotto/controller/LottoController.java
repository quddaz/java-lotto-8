package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoManager;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;



public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final InputParser inputParser;

    public LottoController(InputView inputView, OutputView outputView,
                           LottoMachine lottoMachine, InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
        this.inputParser = inputParser;
    }

    public void run() {
        outputView.printPurchaseMessage();
        int purchaseAmount = inputParser.parseToInt(inputView.readInput());


    }
}
