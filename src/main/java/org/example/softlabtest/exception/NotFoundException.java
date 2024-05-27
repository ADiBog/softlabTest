package org.example.softlabtest.exception;

/**
 * Исключение, выбрасываемое при попытке найти несуществующий ресурс.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Конструктор, принимающий сообщение об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public NotFoundException(String message) {
        super(message);
    }
}
