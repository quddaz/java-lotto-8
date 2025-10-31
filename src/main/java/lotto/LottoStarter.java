package lotto;

import lotto.domain.lotto.Lottos;
import lotto.domain.buy.LottoBuyMoney;
import lotto.util.InputParser;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoStarter {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final InputParser inputParser;

    public LottoStarter(InputView inputView, OutputView outputView, LottoNumberGenerator lottoNumberGenerator , InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.inputParser = inputParser;
    }

    public void run() {
        outputView.printPurchaseMessage();
        LottoBuyMoney purchaseAmount = new LottoBuyMoney(inputParser.parseToInt(inputView.readInput()));
        Lottos lottoManager = new Lottos(purchaseAmount.getLottoCount(), lottoNumberGenerator);

        outputView.printPurchasedLottoMessage(purchaseAmount.getLottoCount());
        outputView.printLottoNumbers(lottoManager.lottoNumber());

        outputView.printPrizeLottoMessage();
        List<Integer> prizeNumbers = inputParser.parseToLottoNumbers(inputView.readInput());

        outputView.printBonusNumberMessage();
        int bonusNumber = inputParser.parseToInt(inputView.readInput());




    }
}
