package lotto.exception;

public enum DomainExceptionMessage {
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_SIZE("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_INPUT_FORMAT("[ERROR] 입력 형식이 올바르지 않습니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자 형식이 올바르지 않습니다."),
    INVALID_PARSEABLE_NUMBER("[ERROR] 구매 금액은 숫자여야 합니다.");

    private final String message;

    DomainExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}