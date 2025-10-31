package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoManager;
import lotto.domain.PurchaseAmount;
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
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputParser.parseToInt(inputView.readInput()));

        LottoManager lottoManager = new LottoManager(
                lottoMachine.createLottos(purchaseAmount.getLottoCount())
        );

        outputView.printPurchasedLottoMessage(purchaseAmount.getLottoCount());
        outputView.printLottoNumbers(lottoManager.lottoNumber());

    }
}
