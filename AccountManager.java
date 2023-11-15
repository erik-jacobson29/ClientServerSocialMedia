import java.io.*;
import java.util.*;

/**
 * Class that keeps track of all user accounts
 *
 * @author Abhinav Dusi, Erik Jacobson
 * @version December 6, 2020
 */
public class AccountManager {
    private ArrayList<Account> accounts;
    private String filename;

    public AccountManager(String filename) {
        accounts = new ArrayList<Account>(0);
        this.filename = filename;
        try {
            readAccountsFromFile();
        } catch (Exception e) {
        }
    }

    public void readAccountsFromFile() throws IOException, ClassNotFoundException {
        accounts = InputOutput.readAccountsFromFile(filename);
    }

    public void writeAccountsToFile() throws IOException, ClassNotFoundException {
        InputOutput.writeAccountsToFile(accounts, filename);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public void deleteAccount(Account a) {
        accounts.remove(a);
        for (Account account : accounts) {
            account.getFollowers().remove(a);
            account.getFollowing().remove(a);
            account.getRequestsMe().remove(a);
            account.getMeRequested().remove(a);
        }
    }

    public Account getAccountFromUsername(String username) throws AccountNotFoundException {
        for (Account a : accounts) {
            if (a.getUsername().equals(username)) {
                return a;
            }
        }
        throw new AccountNotFoundException("The username you entered does not exist!");
    }

    public void sendFollowRequest(Account user, Account a) {
        if (!a.getRequestsMe().contains(user)) {
            a.getRequestsMe().add(user);
        }
        if (!user.getMeRequested().contains(a)) {
            user.getMeRequested().add(a);
        }
    }

    public void unsendFollowRequest(Account user, Account a) {
        a.getRequestsMe().remove(user);
        user.getMeRequested().remove(a);
    }

    public void acceptFollowRequest(Account user, Account follower) {
        user.getRequestsMe().remove(follower);
        if (!user.getFollowers().contains(follower)) {
            user.getFollowers().add(follower);
        }
        follower.getMeRequested().remove(user);
        if (!follower.getFollowing().contains(user)) {
            follower.getFollowing().add(user);
        }
    }

    public void rejectFollowRequest(Account user, Account follower) {
        user.getRequestsMe().remove(follower);
        follower.getMeRequested().remove(user);
    }

    public boolean verifyAccount(String username, String password) throws AccountNotFoundException {
        Account a = getAccountFromUsername(username);
        return (a.getPassword().equals(password));
    }

}

