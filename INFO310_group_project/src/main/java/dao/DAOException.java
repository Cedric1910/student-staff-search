package dao;

/**
 * INFO210
 * DAOException.java
 * @author Hugo Baird
 */

public class DAOException extends RuntimeException {
    public DAOException(String reason) {
        super(reason);
    }
    public DAOException(String reason, Throwable cause) {
        super(reason, cause);
    }
}