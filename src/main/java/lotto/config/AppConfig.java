package lotto.config;

import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}
