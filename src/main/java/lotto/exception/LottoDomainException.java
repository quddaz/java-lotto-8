package lotto.exception;

public class LottoDomainException extends IllegalArgumentException {

    public LottoDomainException(DomainExceptionMessage message) {
        super(message.message());
    }

    public LottoDomainException(DomainExceptionMessage message, Throwable cause) {
        super(message.message(), cause);
    }
}