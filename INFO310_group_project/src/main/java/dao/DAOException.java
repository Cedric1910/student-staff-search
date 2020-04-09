/**
 * INFO210
 * DAOException.java
 * @author Hugo Baird
 */

package dao;

/**
 * Forwards DAO exception/Run Time exceptions to console
 * when errors occur during database access.
 */
public class DAOException extends RuntimeException {
    public DAOException(String reason) {
        super(reason);
    }
    
    public DAOException(String reason, Throwable cause) {
        super(reason, cause);
    }
}