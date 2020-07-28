package by.epam.info_handling.dao.exception;

public class DaoException extends RuntimeException {
    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }
}
