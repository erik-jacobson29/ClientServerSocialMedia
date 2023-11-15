import java.io.*;
import java.util.*;

/**
 * Class reads and writes information to file
 *
 * @author Abhinav Dusi, Erik Jacobson
 * @version December 7, 2020
 */
public class InputOutput {
    public static ArrayList<Account> readAccountsFromFile(String filename) throws IOException, ClassNotFoundException {
        ArrayList<Account> accounts = new ArrayList<Account>();
        FileInputStream fis = new FileInputStream(new File(filename));
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (true) {
            try {
                Account add = (Account) ois.readObject();
                accounts.add(add);
            } catch (EOFException e) {
                break;
            }
        }
        ois.close();
        fis.close();
        return accounts;
    }

    public static void writeAccountsToFile(ArrayList<Account> accounts, String filename) throws IOException, ClassNotFoundException {
        PrintWriter pw = new PrintWriter(new File(filename));
        pw.print("");
        pw.close();

        FileOutputStream fos = new FileOutputStream(new File(filename));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Account account : accounts) {
            oos.writeObject(account);
        }

        oos.flush();
        oos.close();
    }
}
