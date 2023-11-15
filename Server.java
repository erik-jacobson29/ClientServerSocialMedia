import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Server Class
 *
 * @author Abhinav Dusi
 * @version December 6, 2020
 */
public class Server implements Runnable {
    private static AccountManager am;
    Socket socket;
    private int numClients;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {

        // Open socket at agreed port. 
        ServerSocket serverSocket = new ServerSocket(4242);

        // Initialize account manager with data file
        am = new AccountManager("Data.txt");

        // Keep server running and waiting for connections
        while (true) {
            Socket socket = serverSocket.accept();
            Server server = new Server(socket);

            // Create new thread for each connected client
            new Thread(server).start();
        }
    }

    public void run() {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());
            Account account = null;

            // Server needs to constantly hear for input from client
            while (true) {
                if (in.hasNext()) {
                    int option = Integer.parseInt(in.nextLine());

                    if (option == 1) { // Exit Application
                        break;
                    }
                    if (option == 2) { // Login
                        String username = in.nextLine();
                        String password = in.nextLine();

                        try {
                            if (am.verifyAccount(username, password)) {
                                account = am.getAccountFromUsername(username);

                                pw.println(0); // Logged in
                                pw.println(account.getEmail());
                                pw.println(account.getFullName());
                                pw.println(account.getHomeTown());
                                pw.println(account.getInterests());
                                pw.println(account.getAboutMe());
                                pw.flush();

                            } else {
                                pw.println(1); // Incorrect Password
                            }
                        } catch (AccountNotFoundException e) {
                            pw.println(2); // Username not found
                        }

                        pw.flush();
                    }
                    if (option == 3) { // Create Account
                        String username = in.nextLine();
                        String password = in.nextLine();
                        String fullName = in.nextLine();
                        String email = in.nextLine();

                        boolean accountExists = true;
                        try {
                            am.getAccountFromUsername(username);
                        } catch (AccountNotFoundException e) {
                            accountExists = false;
                        }

                        if (!accountExists) {
                            account = new Account(username, password, fullName, email);
                            am.addAccount(account);

                            pw.println(0);
                        } else {
                            pw.println(1);
                        }

                        pw.flush();
                    }
                    if (option == 4) { // Delete account
                        am.deleteAccount(account);
                        pw.println(0);
                        pw.flush();

                    }
                    if (option == 5) { // View Profile
                        String username = in.nextLine();

                        Account accountPf = null;
                        try {
                            accountPf = am.getAccountFromUsername(username);
                        } catch (AccountNotFoundException e) {
                            e.printStackTrace();
                        }

                        if (accountPf == null) {
                            pw.println(1); // Account does not exist
                        } else {
                            pw.println(0); // send profile to client
                            pw.println(accountPf.getProfile());
                        }
                        pw.flush();
                    }
                    if (option == 6) { // Lists all users
                        ArrayList<Account> accounts = am.getAccounts();

                        int size = accounts.size();
                        pw.println(size);

                        for (int i = 0; i < size; i++) {
                            pw.println(accounts.get(i).getUsername());
                            pw.println(accounts.get(i).getFullName());
                        }

                        pw.flush();
                    }
                    if (option == 7) { // Get all followers
                        ArrayList<Account> followers = account.getFollowers();

                        int size = followers.size();
                        pw.println(size);

                        for (int i = 0; i < size; i++) {
                            pw.println(followers.get(i).getUsername());
                            pw.println(followers.get(i).getFullName());
                        }

                        pw.flush();
                    }
                    if (option == 8) { // Get outgoing friend requests
                        ArrayList<Account> meRequested = account.getMeRequested();

                        int size = meRequested.size();
                        pw.println(size);

                        for (int i = 0; i < size; i++) {
                            pw.println(meRequested.get(i).getUsername());
                            pw.println(meRequested.get(i).getFullName());
                        }

                        pw.flush();
                    }
                    if (option == 9) { // Get incoming friend requests
                        ArrayList<Account> requestsMe = account.getRequestsMe();

                        int size = requestsMe.size();
                        pw.println(size);

                        for (int i = 0; i < size; i++) {
                            pw.println(requestsMe.get(i).getUsername());
                            pw.println(requestsMe.get(i).getFullName());
                        }

                        pw.flush();
                    }
                    if (option == 10) { // Send follow request
                        try {
                            String username = in.nextLine();
                            Account send = am.getAccountFromUsername(username);

                            am.sendFollowRequest(account, send);
                            pw.println(0);
                        } catch (AccountNotFoundException e) {
                            pw.println(1);
                        }

                        pw.flush();
                    }
                    if (option == 11) { // Accept follow request
                        try {
                            String username = in.nextLine();
                            Account accept = am.getAccountFromUsername(username);

                            am.acceptFollowRequest(account, accept);
                            pw.println(0);
                        } catch (AccountNotFoundException e) {
                            pw.println(1);
                        }

                        pw.flush();
                    }
                    if (option == 12) { // Get account info
                        pw.println(account.getUsername());
                        pw.println(account.getEmail());
                        pw.println(account.getFullName());
                        pw.println(account.getHomeTown());
                        pw.println(account.getInterests());
                        pw.println(account.getAboutMe());
                        pw.println(account.getFollowers().size());
                        pw.println(account.getFollowing().size());
                        pw.println(account.getMeRequested().size());
                        pw.println(account.getRequestsMe().size());
                        pw.flush();
                    }
                    if (option == 13) { // Set updated info
                        String newAboutMe = in.nextLine();
                        String newHomeTown = in.nextLine();
                        String newInterest = in.nextLine();

                        account.setAboutMe(newAboutMe);
                        account.setHomeTown(newHomeTown);
                        account.setInterests(newInterest);
                    }
                    if (option == 14) { // Get followers
                        ArrayList<Account> list = account.getFollowers();

                        pw.println(list.size());
                        for (Account a : list) {
                            if (a != null) {
                                pw.println(a.getUsername() + ", " + a.getFullName());
                            }
                        }
                        pw.flush();
                    }
                    if (option == 15) { // Get who you're following
                        ArrayList<Account> list = account.getFollowing();

                        pw.println(list.size());
                        for (Account a : list) {
                            if (a != null) {
                                pw.println(a.getUsername() + ", " + a.getFullName());
                            }
                        }
                        pw.flush();

                    }
                    if (option == 16) { // Get who I requested
                        ArrayList<Account> list = account.getMeRequested();

                        pw.println(list.size());
                        for (Account a : list) {
                            if (a != null) {
                                pw.println(a.getUsername() + "," + a.getFullName());
                            }
                        }
                        pw.flush();

                    }
                    if (option == 17) { // Get who requests me
                        ArrayList<Account> list = account.getRequestsMe();

                        pw.println(list.size());
                        for (Account a : list) {
                            if (a != null) {
                                pw.println(a.getUsername() + ", " + a.getFullName());
                            }
                        }
                        pw.flush();
                    }

                    if (option == 18) { // Remove a follower
                        String username = in.nextLine();
                        try {
                            Account remove = am.getAccountFromUsername(username);
                            if (account != null) {
                                account.getFollowers().remove(remove);
                            }
                            if (remove != null) {
                                remove.getFollowing().remove(account);
                            }
                        } catch (AccountNotFoundException e) {
                        }
                    }
                    if (option == 19) { // Unfollow someone
                        String username = in.nextLine();
                        try {
                            Account remove = am.getAccountFromUsername(username);
                            if (account != null) {
                                account.getFollowing().remove(remove);
                            }
                            if (remove != null) {
                                remove.getFollowers().remove(account);
                            }
                        } catch (AccountNotFoundException e) {
                        }
                    }
                    if (option == 20) { // Unrequest an account
                        String username = in.nextLine();
                        try {
                            Account remove = am.getAccountFromUsername(username);
                            account.getMeRequested().remove(remove);
                            remove.getRequestsMe().remove(account);
                        } catch (AccountNotFoundException e) {
                        }
                    }
                    if (option == 21) { // Get username and full name of an account
                        String username = in.nextLine();
                        try {
                            Account userAccount = am.getAccountFromUsername(username);
                            pw.println(0);
                            pw.println(userAccount.getUsername());
                            pw.println(userAccount.getFullName());
                        } catch (AccountNotFoundException e) {
                            pw.println(1);
                        }
                        pw.flush();
                    }
                    if (option == 22) { // Get all profile info of an account
                        String username = in.nextLine();
                        try {
                            Account userAccount = am.getAccountFromUsername(username);
                            pw.println(0);
                            pw.println(userAccount.getUsername());
                            pw.println(userAccount.getFullName());
                            pw.println(userAccount.getEmail());
                            pw.println(userAccount.getHomeTown());
                            pw.println(userAccount.getAboutMe());
                            pw.println(userAccount.getInterests());
                            pw.println(userAccount.getFollowers().size());
                            pw.println(userAccount.getFollowing().size());

                        } catch (AccountNotFoundException e) {
                            pw.println(1);
                        }
                        pw.flush();
                    }
                    if (option == 23) { // Reject follow request
                        try {
                            String username = in.nextLine();
                            Account reject = am.getAccountFromUsername(username);

                            am.rejectFollowRequest(account, reject);
                            pw.println(0);
                        } catch (AccountNotFoundException e) {
                            pw.println(1);
                        }

                        pw.flush();
                    }

                    am.writeAccountsToFile();
                }
            }
            pw.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
