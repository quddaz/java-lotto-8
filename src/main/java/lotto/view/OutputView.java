package lotto.view;

import lotto.domain.LottoResult;

public class OutputView {

    public void printPurchaseMessage() {
        System.out.println(OutputConfig.PURCHASE_MESSAGE.get());
    }

    public void printPurchasedLottoMessage(int count) {
        System.out.printf(OutputConfig.PURCHASED_LOTTO_MESSAGE.get(), count);
    }

    public void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printPrizeLottoMessage() {
        System.out.println(OutputConfig.PRIZE_LOTTO_MESSAGE.get());
    }

    public void printBonusNumberMessage() {
        System.out.println(OutputConfig.BONUS_NUMBER_MESSAGE.get());
    }

    public void printResultMessage(LottoResult lottoResult) {
        StringBuilder resultString = new StringBuilder(OutputConfig.STATISTICS_HEADER.get());

        System.out.print(resultString);
    }

    public void printProfitMessage(double profit) {
        System.out.printf(OutputConfig.PROFIT_MESSAGE.get(), profit);
    }
}