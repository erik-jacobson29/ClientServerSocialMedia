import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import java.util.*;

/**
 * Client Class
 *
 * @author Abhinav Dusi, Erik Jacobson
 * @version December 7, 2020
 */
public class Client extends JComponent {
    //create all the frames for the application.
    static JFrame frame;
    static JFrame createGUI;
    static JFrame homeScreen;
    static JFrame editProfileScreen;
    static JFrame followerScreen;
    static JFrame followingScreen;
    static JFrame requestsScreen;
    static JFrame requestedScreen;
    static JFrame viewProfileScreen;
    static JFrame findAccount;
    // Information used to retrieve the users account.
    static String usernameTextValue;
    static String passwordTextValue;
    static String newEmail;
    static String newFullName;
    static int numFollowers;
    static int numFollowing;
    static int numRequests; // requests are you requesting to follow somebody else.
    static int numRequested; // requested are people that have requested to follow you.
    // ArrayLists that can be filled with information to populate a users arrays.
    static ArrayList<String> followersArraylist = new ArrayList<>(0);
    static ArrayList<String> followingArraylist = new ArrayList<>(0);
    static ArrayList<String> requestedArraylist = new ArrayList<>(0);
    static ArrayList<String> requestsArraylist = new ArrayList<>(0);
    static Account userAccount;
    static Scanner in = null;
    static PrintWriter pw = null;

    // this is the first screen that a user will see when they open the application.
    public static void createLogin() {
        frame = new JFrame("Papyrus");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        JPanel usernamePanel = new JPanel();
        JLabel username = new JLabel();
        username.setText("Username:");
        JTextField usernameText = new JTextField(20);
        usernamePanel.add(username);
        usernamePanel.add(usernameText);
        JPanel passwordPanel = new JPanel();
        JLabel password = new JLabel();
        password.setText("Password:");
        JTextField passwordText = new JTextField(20);
        passwordPanel.add(password);
        passwordPanel.add(passwordText);
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLUE);
        submitButton.setSize(10, 4);
        // when the submit button is clicked after a user enters their username and password.
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameTextValue = usernameText.getText();
                passwordTextValue = passwordText.getText();


                // send to server to make sure username and password are correct.
                pw.println(2);
                pw.println(usernameTextValue); // username
                pw.println(passwordTextValue); // password
                pw.flush();


                String response = in.nextLine();
                int err = Integer.parseInt(response);
                if (err != 0) { // If incorrect password, show an error message and prompt the user to try again.
                    JOptionPane.showMessageDialog(frame, "Invalid username/password combination!", "Login"
                            , JOptionPane.ERROR_MESSAGE);
                } else { // If valid username and password login and go to the home screen and
                    // receive the information from the server.
                    String email = in.nextLine();
                    String fullName = in.nextLine();
                    String homeTown = in.nextLine();
                    String interests = in.nextLine();
                    String aboutMe = in.nextLine();
                    userAccount = new Account(usernameTextValue, passwordTextValue, fullName, email);
                    userAccount.setAboutMe(aboutMe);
                    userAccount.setInterests(interests);
                    userAccount.setHomeTown(homeTown);
                    JOptionPane.showMessageDialog(frame, "Success");
                    frame.setVisible(false);
                    homeScreen();
                }
            }
        });
        // more JPanel code.
        JPanel bottomPanel = new JPanel();
        JLabel click = new JLabel("Click");
        JLabel rest = new JLabel();
        rest.setText("To Create A New Account");
        JButton here = new JButton();
        here.setText("Here");
        // instead of logging in, this action listener takes you a screen where you can create an account.
        here.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                createAccountGUI();
            }
        });
        // Putting the JFrame together.
        JPanel topPanel = new JPanel();
        JLabel programName = new JLabel();
        programName.setText("Papyrus");
        topPanel.add(programName);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(usernamePanel, BorderLayout.NORTH);
        centerPanel.add(passwordPanel, BorderLayout.CENTER);
        centerPanel.add(submitButton, BorderLayout.SOUTH);
        bottomPanel.add(click);
        bottomPanel.add(here);
        bottomPanel.add(rest);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static void createAccountGUI() { // this is the screen where you create a screen.

        createGUI = new JFrame("Papyrus");
        createGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createGUI.setSize(640, 480);
        createGUI.setLayout(new GridLayout(7, 1));
        JPanel bottomPanel = new JPanel();
        JButton create = new JButton("Create");
        create.setForeground(Color.BLUE);
        JLabel fullName = new JLabel("Full Name");
        JTextField fullNameText = new JTextField(25);
        JLabel email = new JLabel("      Email");
        JTextField emailText = new JTextField(25);
        JLabel username = new JLabel("Username");
        JTextField usernameText = new JTextField(25);
        JLabel password = new JLabel("Password");
        JTextField passwordText = new JTextField(25);
        JLabel top = new JLabel("Create a new Account");
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel emailPanel = new JPanel();
        JPanel fullNamePanel = new JPanel();
        usernamePanel.add(username);
        usernamePanel.add(usernameText);
        passwordPanel.add(password);
        passwordPanel.add(passwordText);
        emailPanel.add(email);
        emailPanel.add(emailText);
        fullNamePanel.add(fullName);
        fullNamePanel.add(fullNameText);
        JLabel blank = new JLabel("");
        JLabel header = new JLabel("Create an Account");
        header.setFont(new Font("Serif", Font.PLAIN, 20));
        JButton back = new JButton("Back to Login");
        bottomPanel.add(create);
        bottomPanel.add(back);
        back.addActionListener(new ActionListener() { // back to the login screen.
            @Override
            public void actionPerformed(ActionEvent e) {
                createGUI.setVisible(false);
                createLogin();
            }
        });

        createGUI.add(header);
        createGUI.add(usernamePanel);
        createGUI.add(passwordPanel);
        createGUI.add(fullNamePanel);
        createGUI.add(emailPanel);
        createGUI.add(blank);
        createGUI.add(bottomPanel);
        createGUI.setVisible(true);
        // sends information in the text fields to the servers
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newEmail = emailText.getText();
                newFullName = fullNameText.getText();
                passwordTextValue = passwordText.getText();
                usernameTextValue = usernameText.getText();
                // make sure username is in the correct format.
                if (usernameTextValue.length() > 10 || usernameTextValue.contains(",")) {
                    JOptionPane.showMessageDialog(createGUI,
                            "Make sure your username is 10 characters or " +
                                    "less and does not contain commas.", "MyFace", JOptionPane.ERROR_MESSAGE);
                }
                // make sure email is valid and contains an @.
                else if (!newEmail.contains("@")) {
                    JOptionPane.showMessageDialog(createGUI, "Please enter a valid email address",
                            "MyFace", JOptionPane.ERROR_MESSAGE);
                } else if (newEmail.length() == 0 || newFullName.length() == 0 || passwordTextValue.length() == 0
                        || usernameTextValue.length() == 0) {
                    JOptionPane.showMessageDialog(createGUI,
                            "Make sure you fill all out all the required " +
                                    "fields", "Papyrus", JOptionPane.ERROR_MESSAGE);
                } else {
                    // send the information to the server and create a new account.
                    pw.println(3);
                    pw.println(usernameTextValue); // username
                    pw.println(passwordTextValue); // password
                    pw.println(newFullName); // Full Name
                    pw.println(newEmail); // Email
                    pw.flush();

                    // last check is to make sure that a user with this account does not already exist.
                    String response = in.nextLine();
                    int err = Integer.parseInt(response);
                    if (err != 0) { // Account Already Exists. Prompts user to choose a new user name.
                        JOptionPane.showMessageDialog(createGUI, "An Account With This" +
                                        " Username Already Exists, " + "Please try a different Username!",
                                "New Account GUI", JOptionPane.ERROR_MESSAGE);
                    } else { // Account does not exist and creates an account with the users specified objects.
                        JOptionPane.showMessageDialog(createGUI, "Account Created Successfully");
                        userAccount = new Account(usernameTextValue, passwordTextValue, newFullName, newEmail);
                        createGUI.setVisible(false);
                        homeScreen();
                    }
                }
            }
        });
    }

    public static void homeScreen() { // the users home screen.
        // Designs the gui for the home screen.
        homeScreen = new JFrame("Papyrus");
        homeScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        homeScreen.setSize(640, 480);
        JPanel followerPanel = new JPanel();
        followerPanel.setLayout(new GridLayout(1, 2));
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(2, 2));
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(2, 1));
        JPanel aboutInfo = new JPanel();
        aboutInfo.setLayout(new GridLayout(2, 1));
        JPanel editOrDelete = new JPanel();
        // sends and receives from the server in order to get all the account information like a list of followers.
        pw.println(12);
        pw.flush();
        String accountUsername = in.nextLine();
        String accountEmail = in.nextLine();
        String accountFullName = in.nextLine();
        String accountHomeTown = in.nextLine();
        String accountInterests = in.nextLine();
        String accountAboutMe = in.nextLine();
        String accountFollowerSize = in.nextLine();
        numFollowers = Integer.parseInt(accountFollowerSize);
        String accountFollowingSize = in.nextLine();
        numFollowing = Integer.parseInt(accountFollowingSize);
        String meRequestedSize = in.nextLine();
        numRequested = Integer.parseInt(meRequestedSize);
        String requestsSize = in.nextLine();
        numRequests = Integer.parseInt(requestsSize);
        JLabel username = new JLabel("@" + accountUsername);
        username.setFont(new Font("Serif", Font.BOLD, 40));
        JLabel aboutMe = new JLabel("<html>About me:\n" + accountAboutMe + "<html>");
        aboutMe.setFont(new Font("Serif", Font.PLAIN, 24));
        JLabel email = new JLabel("Email: " + accountEmail);
        email.setFont(new Font("Serif", Font.PLAIN, 22));
        JLabel fullName = new JLabel(accountFullName);
        fullName.setFont(new Font("Serif", Font.PLAIN, 22));
        JLabel hometown = new JLabel("Hometown: " + accountHomeTown);
        hometown.setFont(new Font("Serif", Font.PLAIN, 22));
        JLabel interests = new JLabel("<html>Interests:\n" + accountInterests + "<html>");
        interests.setFont(new Font("Serif", Font.PLAIN, 24));
        JButton followRequests = new JButton("Requests");
        JButton editProfile = new JButton("Edit Profile");
        editProfile.setForeground(Color.BLUE);
        editProfile.setOpaque(true);
        JButton followers = new JButton("Followers: " + accountFollowerSize);
        JButton following = new JButton(("Following: " + accountFollowingSize));
        JButton requested = new JButton("Requested");
        JButton findUsers = new JButton("Find Accounts");
        JButton deleteAccount = new JButton("Delete Account");
        deleteAccount.setForeground(Color.RED);
        deleteAccount.setOpaque(true);
        JButton logOff = new JButton("Sign Out");
        followerPanel.add(followers);
        followerPanel.add(following);
        followerPanel.add(followRequests);
        followerPanel.add(requested);
        followerPanel.add(findUsers);
        namePanel.add(username);
        namePanel.add(hometown);
        namePanel.add(fullName);
        namePanel.add(email);
        informationPanel.add(aboutMe);
        informationPanel.add(interests);
        editOrDelete.add(editProfile);
        editOrDelete.add(logOff);
        editOrDelete.add(deleteAccount);
        centerPanel.add(followerPanel, BorderLayout.NORTH);
        centerPanel.add(informationPanel, BorderLayout.CENTER);
        homeScreen.add(namePanel, BorderLayout.NORTH);
        homeScreen.add(centerPanel, BorderLayout.CENTER);
        homeScreen.add(editOrDelete, BorderLayout.SOUTH);
        homeScreen.setVisible(true);
        // takes you to the search Account Screen
        findUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(false);
                searchAccountScreen();
            }
        });
        // logs off and returns to the login screen.
        logOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(false);
                createLogin();
            }
        });
        // takes you to your list of followers.
        followers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(false);
                followerScreen();
            }
        });
        // takes you to your list of following.
        following.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(false);
                followingScreen();
            }
        });
        // takes you to your list of the people that you've requested.
        requested.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(false);
                requested();
            }
        });
        // takes you to your list of follow requests.
        followRequests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(false);
                requests();
            }
        });
        // adds functionality so that when an account is deleted, all instances of the account are deleted.
        deleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(homeScreen,
                        "Are you sure You want to delete your" +
                                " Account?", "Delete Account", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                // updates the server and the Account Manager.
                if (choice == 0) {
                    JOptionPane.showMessageDialog(homeScreen, "Account Deleted");
                    homeScreen.setVisible(false);
                    pw.println(4);
                    pw.flush();
                    in.nextLine();
                    createLogin();
                }
            }
        });
        // Allows the user to update their profile information such as hometown, about me, and interests.
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProfileScreen(accountHomeTown, accountAboutMe, accountInterests);
                homeScreen.setVisible(false);
            }
        });
    }

    public static void editProfileScreen(String currHomeTown, String currAboutMe, String currInterests) {
        // creates the GUI for the edit profile Screen.
        editProfileScreen = new JFrame("Papyrus");
        editProfileScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editProfileScreen.setSize(640, 480);
        editProfileScreen.setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 1));
        JPanel aboutPanel = new JPanel();
        JPanel hometownPanel = new JPanel();
        JPanel interestsPanel = new JPanel();
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(hometownPanel, BorderLayout.WEST);
        JLabel hometown = new JLabel("Hometown");
        JLabel aboutMe = new JLabel("About Me");
        JLabel interests = new JLabel("Interests");
        JButton editProfile = new JButton("Update");
        editProfile.setForeground(Color.BLUE);
        editProfile.setOpaque(true);
        JTextField hometownText = new JTextField(currHomeTown, 25);
        JTextArea aboutMeText = new JTextArea(currAboutMe, 8, 50);
        aboutMeText.setLineWrap(true);
        aboutMeText.setWrapStyleWord(true);
        JTextArea interestsText = new JTextArea(currInterests, 5, 50);
        interestsText.setLineWrap(true);
        interestsText.setWrapStyleWord(true);
        hometownPanel.add(hometown);
        hometownPanel.add(hometownText);
        aboutPanel.add(aboutMe);
        aboutPanel.add(aboutMeText);
        interestsPanel.add(interests);
        interestsPanel.add(interestsText);
        infoPanel.add(aboutPanel);
        infoPanel.add(interestsPanel);
        editProfileScreen.add(northPanel, BorderLayout.NORTH);
        editProfileScreen.add(infoPanel, BorderLayout.CENTER);
        editProfileScreen.add(editProfile, BorderLayout.SOUTH);
        editProfileScreen.setVisible(true);
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //asks the user if they want to edit their profiles.
                int choice = JOptionPane.showConfirmDialog(editProfileScreen, "Are you sure you want " +
                                "to update your profile?", "Update Profile", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (choice == 0) { // if the user confirms that they want to uupdate their profile.
                    String about = aboutMeText.getText().replaceAll("\n", ". ");
                    String interest = interestsText.getText().replaceAll("\n", ". ");
                    if (about.length() > 550 || interest.length() > 550) {// makes sure the information is not too long.
                        JOptionPane.showMessageDialog(editProfileScreen,
                                "Please Shorten your 'About Me' and" +
                                        " 'Interest' information to 700 characters or less!", "Edit Profile",
                                JOptionPane.ERROR_MESSAGE);
                    } else { // if not too long then it updates the users information in the server.
                        pw.println(13);
                        pw.println(about);
                        pw.println(hometownText.getText().replaceAll("\n", ". "));
                        pw.println(interest);
                        pw.flush();
                        editProfileScreen.setVisible(false);
                        homeScreen();
                        JOptionPane.showMessageDialog(homeScreen, "Account Updated");
                    }
                }
            }
        });
    }

    public static void followerScreen() { // the screen displayed when you click on the follower button.
        followersArraylist = new ArrayList<>(0);
        followingArraylist = new ArrayList<>(0);
        followerScreen = new JFrame("Papyrus");
        followerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        followerScreen.setSize(640, 480);
        followerScreen.setLayout(new BorderLayout());
        // requests from the server and receives a list of followers of that user.
        pw.println(14);
        pw.flush();
        // reads in the followers of that user.
        numFollowers = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numFollowers; i++) {
            followersArraylist.add(in.nextLine());
        }
        // reads in the accounts that the user is following.
        pw.println(15);
        pw.flush();
        numFollowing = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numFollowing; i++) {
            followingArraylist.add(in.nextLine());
        }
        // Creates the GUI
        JPanel followers = new JPanel();
        followers.add(new JLabel("Followers"));
        JPanel home = new JPanel();
        JButton returnHome = new JButton("Back to Profile");
        home.add(returnHome);
        JPanel centerPanel = new JPanel();
        JScrollPane followPane = new JScrollPane(centerPanel);
        if (numFollowers == 0) { // checks if the user has an followers.
            centerPanel.add(new JLabel("You have no followers yet. " +
                    "Start following others to gain more followers!"));
        } else {
            ArrayList<String> userNames = new ArrayList<>(0);
            if (followingArraylist.size() != 0) {
                for (String a : followingArraylist) {
                    userNames.add(a.substring(0, a.indexOf(",")));
                }
            }
            if (numFollowers < 10) { // just makes it so that each username takes about 1/10 of the panel.
                centerPanel.setLayout(new GridLayout(10, 1));
            } else centerPanel.setLayout(new GridLayout(numFollowers, 1));
            for (int i = 0; i < numFollowers; i++) { // creates a new Panel to display for every follower of the user.
                JPanel newPanel = new JPanel();
                int index = followersArraylist.get(i).indexOf(",");
                JLabel usernameLabel = new JLabel("@" + followersArraylist.get(i).substring(0, index));
                usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
                JLabel fullNameLabel = new JLabel(followersArraylist.get(i).substring(index + 1));
                fullNameLabel.setForeground(Color.GRAY);
                newPanel.add(usernameLabel);
                newPanel.add(fullNameLabel);
                String currentAccount = followersArraylist.get(i).substring(0, index);
                if (!userNames.contains((currentAccount.substring(0, index)))) {
                    // checks if the user is following that specific follower. If not displays a follow back button.
                    JButton request = new JButton("Follow Back");
                    request.setForeground(Color.BLUE);
                    newPanel.add(request);
                    request.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            request.setText("Request Sent");
                            // implements sending a friend request to another user. Sends that data to the server.
                            pw.println(10);
                            pw.println(currentAccount);
                            pw.flush();
                            in.nextLine();
                        }
                    });
                }
                // button that allows you to remove a follower.
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int choice = JOptionPane.showConfirmDialog(followerScreen,
                                "Are you sure you want to remove this Follower? \n " +
                                        "They will no longer be able to view your profile!",
                                "Remove Follower",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (choice != 1) {
                            removeButton.setText("Removed");
                            userAccount.getFollowers().remove(currentAccount);
                            // sends to the server that this follower is to be removed.
                            pw.println(18);
                            pw.println(currentAccount);
                            pw.flush();
                        }
                    }
                });
                removeButton.setForeground(Color.RED);
                newPanel.add(removeButton);
                centerPanel.add(newPanel);

            }
        }
        // back button that takes the user back to their home screen.
        returnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                followerScreen.setVisible(false);
                homeScreen();
            }
        });
        // put together the frame and make it visible.
        followerScreen.add(followers, BorderLayout.NORTH);
        followerScreen.add(followPane, BorderLayout.CENTER);
        followerScreen.add(home, BorderLayout.SOUTH);
        followerScreen.setVisible(true);
    }

    public static void followingScreen() {
        // the screen displayed when you click on the following button.
        followingArraylist = new ArrayList<>(0);
        requestsArraylist = new ArrayList<>(0);
        followingScreen = new JFrame("Papyrus");
        followingScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        followingScreen.setSize(640, 480);
        followingScreen.setLayout(new BorderLayout());

        // receive from the server the user list of following.
        pw.println(15);
        pw.flush();
        numFollowing = Integer.parseInt(in.nextLine());
        // loads that data in from the server.
        for (int i = 0; i < numFollowing; i++) {
            followingArraylist.add(in.nextLine());
        }
        // Creation of the GUI.
        JPanel followers = new JPanel();
        followers.add(new JLabel("Following"));
        JPanel home = new JPanel();
        JButton returnHome = new JButton("Back to Profile");
        home.add(returnHome);
        JPanel centerPanel = new JPanel();
        JScrollPane followPane = new JScrollPane(centerPanel);
        if (numFollowing == 0) { // checks if the user is following anybody
            centerPanel.add(new JLabel("You are not following anybody. " +
                    "Find some new accounts to follow"));
        } else {
            ArrayList<String> requested = new ArrayList<>(0);
            if (requested.size() != 0) {
                for (String a : requestedArraylist) {
                    requested.add(a.substring(0, a.indexOf(",")));
                }
            }
            if (numFollowing < 10) { // makes it so that size and spacing are uniform.
                centerPanel.setLayout(new GridLayout(10, 1));
            } else centerPanel.setLayout(new GridLayout(numFollowing, 1));
            for (int i = 0; i < numFollowing; i++) {
                JPanel newPanel = new JPanel();
                int index = followingArraylist.get(i).indexOf(",");
                JLabel usernameLabel = new JLabel("@" + followingArraylist.get(i).substring(0, index));
                usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
                JLabel fullNameLabel = new JLabel(followingArraylist.get(i).substring(index + 1));
                fullNameLabel.setForeground(Color.GRAY);
                String currentAccount = followingArraylist.get(i).substring(0, index);
                JButton viewProfile = new JButton("View Profile");
                // takes you to the users profile so that you can view it.
                viewProfile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        followingScreen.setVisible(false);
                        pw.println(22);
                        pw.println(currentAccount);
                        pw.flush();
                        in.nextLine();
                        String accountUsername = in.nextLine();
                        String accountFullName = in.nextLine();
                        String accountEmail = in.nextLine();
                        String accountHomeTown = in.nextLine();
                        String accountAboutMe = in.nextLine();
                        String accountInterests = in.nextLine();
                        String accountFollowerSize = in.nextLine();
                        int numFollowers = Integer.parseInt(accountFollowerSize);
                        String accountFollowingSize = in.nextLine();
                        int numFollowing = Integer.parseInt(accountFollowingSize);
                        viewProfileScreen(accountUsername, accountFullName, accountEmail, accountHomeTown,
                                accountAboutMe, accountInterests, numFollowers, numFollowing);
                    }
                });
                viewProfile.setForeground(Color.BLUE);
                newPanel.add(usernameLabel);
                newPanel.add(fullNameLabel);
                newPanel.add(viewProfile);

                JButton unfollowButton = new JButton("Unfollow");
                unfollowButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int choice = JOptionPane.showConfirmDialog(followingScreen,
                                "Are you sure you want to unfollow this user? \n " +
                                        "You will no longer be able to view their profile!", "Unfollow",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (choice != 1) {
                            unfollowButton.setText("Unfollowed");
                            numFollowing--;
                            // implement unfollowing a user.

                            pw.println(19);
                            pw.println(currentAccount);
                            pw.flush();
                        }
                    }
                });
                unfollowButton.setForeground(Color.RED);
                newPanel.add(unfollowButton);
                centerPanel.add(newPanel);
                if (requested.contains((currentAccount.substring(0, index)))) {
                    JButton accept = new JButton("Accept Follow Request");
                    accept.setForeground(Color.GREEN);
                    newPanel.add(accept);
                    accept.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            accept.setText("Request Sent");
                            requestsArraylist.add(currentAccount);
                            // accepting a follow request. Sends that information to the server.

                            pw.println(11);
                            pw.println(currentAccount);
                            pw.flush();
                            in.nextLine();
                        }
                    });
                }
            }
        }
        // takes you back to the home screen from the follower screen.
        returnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                followingScreen.setVisible(false);
                homeScreen();
            }
        });
        // puts the pieces together and makes the screen visible
        followingScreen.add(followers, BorderLayout.NORTH);
        followingScreen.add(followPane, BorderLayout.CENTER);
        followingScreen.add(home, BorderLayout.SOUTH);
        followingScreen.setVisible(true);
    }

    // same as the follower and following screen but with the people that you have requested to follow.
    public static void requests() {
        requestsArraylist = new ArrayList<>(0);
        requestsScreen = new JFrame("Papyrus");
        requestsScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        requestsScreen.setSize(640, 480);
        requestsScreen.setLayout(new BorderLayout());
        // gets the requested users.
        pw.println(16);
        pw.flush();

        numRequests = Integer.parseInt(in.nextLine());
        if (numRequests != 0) {
            for (int i = 0; i < numRequests; i++) {
                requestsArraylist.add(in.nextLine());
            }
        }

        JPanel requests = new JPanel();
        requests.add(new JLabel("People you've requested. You will be able to see their profiles " +
                "once they accept your request."));
        JPanel home = new JPanel();
        JButton returnHome = new JButton("Back to Profile");
        home.add(returnHome);
        JPanel centerPanel = new JPanel();
        JScrollPane followPane = new JScrollPane(centerPanel);
        if (numRequests == 0) {
            centerPanel.add(new JLabel("You have not requested to follow anybody"));
        } else { // makes the look uniform regardless of number of people that you have requested.
            if (numRequests < 10) {
                centerPanel.setLayout(new GridLayout(10, 1));
            } else centerPanel.setLayout(new GridLayout(numRequests, 1));
            for (int i = 0; i < numRequests; i++) {
                JPanel newPanel = new JPanel();
                int index = requestsArraylist.get(i).indexOf(",");
                JLabel usernameLabel = new JLabel("@" + requestsArraylist.get(i).substring(0, index));
                usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
                JLabel fullNameLabel = new JLabel(requestsArraylist.get(i).substring(index + 1));
                fullNameLabel.setForeground(Color.GRAY);
                newPanel.add(usernameLabel);
                newPanel.add(fullNameLabel);
                String currentAccount = requestsArraylist.get(i).substring(0, index);
                JButton unfollowButton = new JButton("Unrequest");
                unfollowButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { // user confirms to unrequest the user.
                        int choice = JOptionPane.showConfirmDialog(requestsScreen,
                                "Are you sure you want " +
                                        "to unrequest this user?", "Unfollow", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (choice != 1) {
                            unfollowButton.setText("Unrequested");
                            // sends the information to the server that the user unrequested another user.

                            pw.println(20);
                            pw.println(currentAccount);
                            pw.flush();
                        }
                    }
                });
                unfollowButton.setForeground(Color.RED);
                newPanel.add(unfollowButton);
                centerPanel.add(newPanel);

            }
        }
        returnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestsScreen.setVisible(false);
                homeScreen();
            }
        });
        // puts together the frame and makes it visible.
        requestsScreen.add(requests, BorderLayout.NORTH);
        requestsScreen.add(followPane, BorderLayout.CENTER);
        requestsScreen.add(home, BorderLayout.SOUTH);
        requestsScreen.setVisible(true);
    }

    // same as requests but with those people who have requested to follow you.
    public static void requested() {
        requestedArraylist = new ArrayList<>(0);
        requestedScreen = new JFrame("People I've Requested");
        requestedScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        requestedScreen.setSize(640, 480);
        requestedScreen.setLayout(new BorderLayout());
        pw.println(17);
        pw.flush();
        numRequested = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numRequested; i++) {
            requestedArraylist.add(in.nextLine());
        }

        JPanel requests = new JPanel();
        requests.add(new JLabel("People that have requested to follow you. Once you accept they " +
                "will be able to view your profile."));
        JPanel home = new JPanel();
        JButton returnHome = new JButton("Back to Profile");
        home.add(returnHome);
        JPanel centerPanel = new JPanel();
        JScrollPane followPane = new JScrollPane(centerPanel);
        if (numRequested == 0) {
            centerPanel.add(new JLabel("You have no follow requests"));
        } else {
            if (numRequested < 10) {
                centerPanel.setLayout(new GridLayout(10, 1));
            } else centerPanel.setLayout(new GridLayout(numRequested, 1));
            for (int i = 0; i < numRequested; i++) {
                JPanel newPanel = new JPanel();
                int index = requestedArraylist.get(i).indexOf(",");
                JLabel usernameLabel = new JLabel("@" + requestedArraylist.get(i).substring(0, index));
                usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
                JLabel fullNameLabel = new JLabel(requestedArraylist.get(i).substring(index + 1));
                fullNameLabel.setForeground(Color.GRAY);
                newPanel.add(usernameLabel);
                newPanel.add(fullNameLabel);
                JButton unfollowButton = new JButton("Decline");
                JButton confirmButton = new JButton("Confirm");
                confirmButton.setForeground(Color.GREEN);
                String currentAccount = requestedArraylist.get(i).substring(0, index);
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        confirmButton.setText("Following You");
                        unfollowButton.setVisible(false);
                        // implement adding a follower.
                        pw.println(11);
                        pw.println(currentAccount);
                        pw.flush();
                        in.nextLine();
                    }
                });
                newPanel.add(confirmButton);
                // decline button if you do not want a user to be able to follow you.
                unfollowButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int choice = JOptionPane.showConfirmDialog(requestedScreen,
                                "Are you sure you want " +
                                        "to deny this user from following you?",
                                "Unfollow", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (choice != 1) {
                            unfollowButton.setText("Declined");
                            pw.println(23);
                            pw.println(currentAccount);
                            pw.flush();
                            in.nextLine();

                        }
                    }
                });
                unfollowButton.setForeground(Color.RED);
                newPanel.add(unfollowButton);
                centerPanel.add(newPanel);
            }
        }
        // button that adds functionality and allows you to go back to the home screen.
        returnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestedScreen.setVisible(false);
                homeScreen();
            }
        });
        requestedScreen.add(requests, BorderLayout.NORTH);
        requestedScreen.add(followPane, BorderLayout.CENTER);
        requestedScreen.add(home, BorderLayout.SOUTH);
        requestedScreen.setVisible(true);
    }

    // this creates the frame that you see when you view another users profile.
    public static void viewProfileScreen(String username1, String fullName1, String email1, String hometown1,
                                         String aboutMe1, String interests1,
                                         int numFollowers1, int numFollowing1) {
        //creating the GUI
        viewProfileScreen = new JFrame("Profile");
        viewProfileScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewProfileScreen.setSize(640, 480);
        JPanel followerPanel = new JPanel();
        followerPanel.setLayout(new GridLayout(1, 2));
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(2, 2));
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(2, 1));
        JPanel aboutInfo = new JPanel();
        aboutInfo.setLayout(new GridLayout(2, 1));
        JLabel username = new JLabel("@" + username1);
        username.setFont(new Font("Serif", Font.BOLD, 40));
        JLabel aboutMe = new JLabel("<html>About me:\n" + aboutMe1 + "<html>");
        aboutMe.setFont(new Font("Serif", Font.PLAIN, 24));
        JLabel email = new JLabel("Email: " + email1);
        email.setFont(new Font("Serif", Font.PLAIN, 22));
        JLabel fullName = new JLabel(fullName1);
        fullName.setFont(new Font("Serif", Font.PLAIN, 22));
        JLabel hometown = new JLabel("Hometown: " + hometown1);
        hometown.setFont(new Font("Serif", Font.PLAIN, 22));
        JLabel interests = new JLabel("<html>Interests:\n" + interests1 + "<html>");
        interests.setFont(new Font("Serif", Font.PLAIN, 24));
        JLabel followers = new JLabel("Followers: " + numFollowers1);
        followers.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel following = new JLabel(("Following: " + numFollowing1));
        following.setFont(new Font("Serif", Font.BOLD, 20));
        followerPanel.add(followers);
        followerPanel.add(following);
        namePanel.add(username);
        namePanel.add(hometown);
        namePanel.add(fullName);
        namePanel.add(email);
        JPanel returnHome = new JPanel();
        JButton backHome = new JButton("Return to Profile");
        returnHome.add(backHome);
        informationPanel.add(aboutMe);
        informationPanel.add(interests);
        centerPanel.add(followerPanel, BorderLayout.NORTH);
        centerPanel.add(informationPanel, BorderLayout.CENTER);
        // button that returns the user to the home screen.
        backHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProfileScreen.setVisible(false);
                followingScreen();
            }
        });
        viewProfileScreen.add(namePanel, BorderLayout.NORTH);
        viewProfileScreen.add(centerPanel, BorderLayout.CENTER);
        viewProfileScreen.add(returnHome, BorderLayout.SOUTH);
        viewProfileScreen.setVisible(true);
    }

    public static void searchAccountScreen() {
        findAccount = new JFrame("Find Account");
        findAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        findAccount.setSize(640, 480);
        findAccount.setLayout(new GridLayout(8, 1));
        JPanel header = new JPanel();
        header.add(new JLabel("Find Accounts"));
        JPanel searchLine = new JPanel();
        JButton search = new JButton("Search");
        search.setForeground(Color.BLUE);
        JTextField searchBar = new JTextField(25);
        searchLine.add(new JLabel("Search:"));
        searchLine.add(searchBar);
        searchLine.add(search);
        JPanel accountPanel = new JPanel();
        ArrayList<String> followingArray = new ArrayList<>();
        pw.println(15);
        pw.flush();
        int numFollowing = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numFollowing; i++) {
            String a = in.nextLine();
            followingArray.add(a.substring(0, a.indexOf(",")));
        }
        JButton back = new JButton("Return to Profile");
        // when button is clicked in
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountPanel.setVisible(false);
                accountPanel.removeAll();
                String currentAccount = searchBar.getText();
                pw.println(21);
                pw.println(currentAccount);
                pw.flush();
                int err = Integer.parseInt(in.nextLine());
                if (err == 0) {
                    // Account found
                    String currentAccountUsername = in.nextLine();
                    String currentFullName = in.nextLine();
                    JLabel username = new JLabel(currentAccountUsername);
                    username.setFont(new Font("Serif", Font.PLAIN, 20));
                    JLabel fullName = new JLabel(currentFullName);
                    fullName.setForeground(Color.GRAY);
                    JButton request = new JButton("Request");
                    JButton viewProfile = new JButton("View Profile");
                    // request to follow another user.
                    request.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            request.setText("Requested");
                            pw.println(10);
                            pw.println(currentAccountUsername);
                            pw.flush();
                            in.nextLine();
                        }
                    });
                    // view the users profile from the search screen.
                    viewProfile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            findAccount.setVisible(false);
                            pw.println(22);
                            pw.println(currentAccountUsername);
                            pw.flush();
                            in.nextLine();
                            String accountUsername = in.nextLine();
                            String accountFullName = in.nextLine();
                            String accountEmail = in.nextLine();
                            String accountHomeTown = in.nextLine();
                            String accountAboutMe = in.nextLine();
                            String accountInterests = in.nextLine();
                            String accountFollowerSize = in.nextLine();
                            int numFollowers = Integer.parseInt(accountFollowerSize);
                            String accountFollowingSize = in.nextLine();
                            int numFollowing = Integer.parseInt(accountFollowingSize);
                            viewProfileScreen(accountUsername, accountFullName, accountEmail, accountHomeTown,
                                    accountAboutMe, accountInterests, numFollowers, numFollowing);
                        }
                    });
                    request.setForeground(Color.BLUE);
                    accountPanel.add(username);
                    accountPanel.add(fullName);
                    if (!followingArray.contains(currentAccountUsername) &&
                            !currentAccountUsername.equals(userAccount.getUsername())) {
                        accountPanel.add(request);
                    } else accountPanel.add(viewProfile);
                    accountPanel.setVisible(true);
                } else {
                    // account not found
                    JOptionPane.showMessageDialog(findAccount, "There is no account with this username",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    searchBar.setText("");


                }

            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findAccount.setVisible(false);
                homeScreen();
            }
        });

        findAccount.add(header);
        findAccount.add(searchLine);
        findAccount.add(accountPanel);
        findAccount.add(back);
        findAccount.setVisible(true);
    }

    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket("localhost", 4242);
            in = new Scanner(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    createLogin();
                }
            });
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not establish a connection!",
                    "Client", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
