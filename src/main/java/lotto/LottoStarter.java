package lotto;

import lotto.domain.LottoResult;
import lotto.domain.lotto.Lottos;
import lotto.domain.buy.LottoBuyMoney;
import lotto.domain.lotto.WinningLotto;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoStarter {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStarter(InputView inputView, OutputView outputView, LottoNumberGenerator lottoNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        LottoBuyMoney purchaseAmount = getPurchaseAmount();
        Lottos lottos = generateLottos(purchaseAmount);
        WinningLotto winningLotto = getWinningLotto();

        LottoResult lottoResult = calculateResult(lottos, winningLotto);
        printResult(lottoResult);
    }

    private LottoBuyMoney getPurchaseAmount() {
        outputView.printPurchaseMessage();
        String input = inputView.readInput();
        LottoBuyMoney purchaseAmount = new LottoBuyMoney(input);
        outputView.printPurchasedLottoMessage(purchaseAmount.getLottoCount());
        return purchaseAmount;
    }

    private Lottos generateLottos(LottoBuyMoney purchaseAmount) {
        Lottos lottos = new Lottos(purchaseAmount.getLottoCount(), lottoNumberGenerator);
        outputView.printLottoNumbers(lottos.lottoNumber());
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        outputView.printWinningLottoMessage();
        String winningNumbersInput = inputView.readInput();
        outputView.printBonusNumberMessage();
        String bonusNumberInput = inputView.readInput();
        return WinningLotto.createFrom(winningNumbersInput, bonusNumberInput);
    }

    private LottoResult calculateResult(Lottos lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos, winningLotto);
    }

    private void printResult(LottoResult lottoResult) {
        outputView.printResultMessage(lottoResult);
        double profit = lottoResult.calculateReward();
        outputView.printProfitMessage(profit);
    }
}
