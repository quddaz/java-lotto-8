package lotto.view;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_MESSAGE = "당첨 통계\n---\n";
    private static final String RESULT_MESSAGE = "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printPurchasedLottoMessage(int count) {
        System.out.printf(PURCHASED_LOTTO_MESSAGE, count);
    }

    public void printWinningLottoMessage() {
        System.out.println(WINNING_LOTTO_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printStatisticsMessage() {
        System.out.println(STATISTICS_MESSAGE);
    }

    public void printResultMessage(int[] results) {
        System.out.printf(RESULT_MESSAGE,
            results[0],
            results[1],
            results[2],
            results[3],
            results[4]);
    }

    public void printProfitMessage(double profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }

}
