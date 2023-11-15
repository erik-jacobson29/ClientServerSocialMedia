/**
 * Class that keeps track of all user accounts
 *
 * @author Erik Jacobson
 * @version December 6, 2020
 */
public class AccountNotFoundException extends Exception {
    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
