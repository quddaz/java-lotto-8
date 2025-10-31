package lotto.exception;

public class LottoDomainException extends IllegalArgumentException {

    public LottoDomainException(DomainExceptionMessage message) {
        super(message.message());
    }

}