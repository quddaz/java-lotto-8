package lotto.view;

import lotto.domain.lotto.LottoResult;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String PRIZE_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_MESSAGE = "당첨 통계\n---\n";
    private static final String MATCH_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    private static final String BONUS_MATCH_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printPurchasedLottoMessage(int count) {
        System.out.printf(PURCHASED_LOTTO_MESSAGE, count);
    }

    public void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printPrizeLottoMessage() {
        System.out.println(PRIZE_LOTTO_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printResultMessage(LottoResult lottoResult) {
        StringBuilder resultString = new StringBuilder(STATISTICS_MESSAGE);

        System.out.print(resultString);
    }


    public void printProfitMessage(double profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }

}
