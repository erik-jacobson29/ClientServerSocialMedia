import java.util.ArrayList;
import java.io.*;

/**
 * Account object for storing user information
 *
 * @author Erik Jacobson
 * @version December 6, 2020
 */
public class Account implements Serializable {
    private final String username;
    private final String password;
    private final String fullName;
    private final String email;
    private String homeTown;
    private String contactInformation;
    private String interests;
    private String aboutMe;
    private ArrayList<Account> followers;
    private ArrayList<Account> following;
    private ArrayList<Account> requestsMe;
    private ArrayList<Account> meRequested;

    public Account(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.homeTown = "";
        this.email = email;
        this.contactInformation = "";
        this.interests = "";
        this.aboutMe = "";
        followers = new ArrayList<>(0);
        following = new ArrayList<>(0);
        requestsMe = new ArrayList<>(0);
        meRequested = new ArrayList<>(0);
    }

    public ArrayList<Account> getFollowers() {
        return followers;
    }

    public int numFollowers() {
        return followers.size();
    }

    public int numFollowing() {
        return following.size();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String newHomeTown) {
        homeTown = newHomeTown;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Account> getFollowing() {
        return following;
    }

    public ArrayList<Account> getRequestsMe() {
        return requestsMe;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public ArrayList<Account> getMeRequested() {
        return meRequested;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getProfile() {
        String profile = "";
        profile += "Username: " + username + "\n";
        profile += "Full name: " + fullName + "\n";
        profile += "Home town: " + homeTown + "\n";
        profile += "Email: " + email + "\n";
        profile += "Username: " + username + "\n";
        profile += "Contact info: " + contactInformation + "\n";
        profile += "About me: " + aboutMe + "\n";
        return profile;
    }

}
