package org.microservice.core.common.exception;

/**
 * 可通知的异常
 * @author Rao
 * @Date 2021/11/10
 **/
public class NotifiableImportantException extends ImportantException {
    private static final long serialVersionUID = -3931540596359326493L;

    public NotifiableImportantException() {
        super();
    }

    public NotifiableImportantException(String message) {
        super(message);
    }

    public NotifiableImportantException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotifiableImportantException(Throwable cause) {
        super(cause);
    }

    protected NotifiableImportantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
