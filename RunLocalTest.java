import org.junit.Test;
import org.junit.After;

import java.lang.reflect.Field;


import org.junit.Before;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


import static org.junit.Assert.*;

/**
 * A set of test cases for Project 5.
 *
 * @author Lizzy Kane
 * @version December 7, 2020
 */

class RunLocalTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        @Test(timeout = 1000)
        public void clientTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Client.class;
            modifiers = clazz.getModifiers();
            ;
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            try {
                Class<?> aClass = Class.forName("Client");
            } catch (ClassNotFoundException e) {
                fail("Make sure Client is a class");
            }
            assertFalse("Ensure that 'Client' is NOT abstract", Modifier.isAbstract(modifiers));
            assertTrue("Ensure that 'Client' is public!", Modifier.isPublic(modifiers));
            assertEquals("Ensure that 'Client' class does NOT implement any interfaces!", superinterfaces.length, 0);
            assertEquals("Make sure 'Client' class extends JComponent", superclass, JComponent.class);

            // field tests
            Field[] fields = Client.class.getDeclaredFields();
            if (fields.length < 23) {
                fail("Ensure that you have implemented the 23 required fields!");
                return;
            }
            try {
                Field createGUI = Client.class.getDeclaredField("createGUI");
                if (createGUI.getType() != JFrame.class) {
                    fail("Ensure that your field createGUI in class Client is of type JFrame!");
                    return;
                }
                if (createGUI.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field createGUI in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field createGUI in class Client that is of type JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field frame = Client.class.getDeclaredField("frame");
                if (frame.getType() != JFrame.class) {
                    fail("Ensure that your field frame in class Client is of type JFrame!");
                    return;
                }
                if (frame.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field frame in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frame in class Client that is of type JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field homeScreen = Client.class.getDeclaredField("homeScreen");
                if (homeScreen.getType() != JFrame.class) {
                    fail("Ensure that your field homeScreen  in class Client is of type JFrame!");
                    return;
                }
                if (homeScreen.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field homeScreen  in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field homeScreen in class Client that is of type JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field editProfileScreen = Client.class.getDeclaredField("editProfileScreen");
                if (editProfileScreen.getType() != JFrame.class) {
                    fail("Ensure that your field editProfileScreen in class Client is of type JFrame!");
                    return;
                }
                if (editProfileScreen.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field editProfileScreen in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field editProfileScreen in class Client that is of type " +
                        "JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field editProfileScreen = Client.class.getDeclaredField("followerScreen");
                if (editProfileScreen.getType() != JFrame.class) {
                    fail("Ensure that your field followerScreen in class Client is of type JFrame!");
                    return;
                }
                if (editProfileScreen.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field followerScreen in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field followerScreen in class Client that is of type " +
                        "JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field editProfileScreen = Client.class.getDeclaredField("followingScreen");
                if (editProfileScreen.getType() != JFrame.class) {
                    fail("Ensure that your field followingScreen in class Client is of type JFrame!");
                    return;
                }
                if (editProfileScreen.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field followingScreen in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field followingScreen in class Client that is of type " +
                        "JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field editProfileScreen = Client.class.getDeclaredField("requestsScreen");
                if (editProfileScreen.getType() != JFrame.class) {
                    fail("Ensure that your field requestsScreen in class Client is of type JFrame!");
                    return;
                }
                if (editProfileScreen.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field requestsScreen in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field requestsScreen in class Client that is of type " +
                        "JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field editProfileScreen = Client.class.getDeclaredField("requestedScreen");
                if (editProfileScreen.getType() != JFrame.class) {
                    fail("Ensure that your field frequestedScreen in class Client is of type JFrame!");
                    return;
                }
                if (editProfileScreen.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field requestedScreen in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field requestedScreen in class Client that is of type " +
                        "JFrame and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field usernameTextValue = Client.class.getDeclaredField("usernameTextValue");
                if (usernameTextValue.getType() != String.class) {
                    fail("Ensure that your field usernameTextValue in class Client is of type String!");
                    return;
                }
                if (usernameTextValue.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field usernameTextValue in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field usernameTextValue in class Client that is of type " +
                        "String and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field passwordTextValue = Client.class.getDeclaredField("passwordTextValue");
                if (passwordTextValue.getType() != String.class) {
                    fail("Ensure that your field passwordTextValue in class Client is of type String!");
                    return;
                }
                if (passwordTextValue.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field passwordTextValue in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field passwordTextValue in class Client that is of type " +
                        "String and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newEmail = Client.class.getDeclaredField("newEmail");
                if (newEmail.getType() != String.class) {
                    fail("Ensure that your field newEmail in class Client is of type String!");
                    return;
                }
                if (newEmail.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field newEmail in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field newEmail in class Client that is of type String and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("newFullName");
                if (newFullName.getType() != String.class) {
                    fail("Ensure that your field newFullName in class Client is of type String!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field newFullName in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field newFullName in class Client that is of type String and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("numFollowers");
                if (newFullName.getType() != int.class) {
                    fail("Ensure that your field numFollowers in class Client is of type int!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field numFollowers in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field numFollowers in class Client that is of type int and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("numFollowing");
                if (newFullName.getType() != int.class) {
                    fail("Ensure that your field numFollowing in class Client is of type int!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field numFollowing in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field numFollowing in class Client that is of type int and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("numRequests");
                if (newFullName.getType() != int.class) {
                    fail("Ensure that your field numRequests in class Client is of type int!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field numRequests in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field numRequests in class Client that is of type int and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("numRequested");
                if (newFullName.getType() != int.class) {
                    fail("Ensure that your field numRequested in class Client is of type int!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field numRequested in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field numRequested in class Client that is of type int and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("followersArraylist");
                if (newFullName.getType() != ArrayList.class) {
                    fail("Ensure that your field followersArraylist in class Client is of type ArrayList!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field followersArraylist in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field followersArraylist in class" +
                        " Client that is of type ArrayList and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("followingArraylist");
                if (newFullName.getType() != ArrayList.class) {
                    fail("Ensure that your field followingArraylist in class Client is of type ArrayList!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field followingArraylist in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field followingArraylist in class Client that is " +
                        "of type ArrayList and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("requestedArraylist");
                if (newFullName.getType() != ArrayList.class) {
                    fail("Ensure that your field requestedArraylist in class Client is of type ArrayList!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field requestedArraylist in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field requestedArraylist in class Client that is " +
                        "of type ArrayList and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field newFullName = Client.class.getDeclaredField("requestsArraylist");
                if (newFullName.getType() != ArrayList.class) {
                    fail("Ensure that your field requestsArraylist in class Client is of type ArrayList!");
                    return;
                }
                if (newFullName.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field requestsArraylist in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field requestsArraylist in class Client " +
                        "that is of type ArrayList and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field userAccount = Client.class.getDeclaredField("userAccount");
                if (userAccount.getType() != Account.class) {
                    fail("Ensure that your field userAccount in class Client is of type Account!");
                    return;
                }
                if (userAccount.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field userAccount in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field userAccount in class Client that is of type Account and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field in = Client.class.getDeclaredField("in");
                if (in.getType() != Scanner.class) {
                    fail("Ensure that your field in in class Client is of type Scanner!");
                    return;
                }
                if (in.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field in in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field in in class Client that is of type Account and is static.");
                e.printStackTrace();
                return;
            }
            try {
                Field pw = Client.class.getDeclaredField("pw");
                if (pw.getType() != PrintWriter.class) {
                    fail("Ensure that your field pw in class Client is of type Account!");
                    return;
                }
                if (pw.getModifiers() != Modifier.STATIC) {
                    fail("Ensure that your field pw in class Client is static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field pw in class Client that is of type Account and is static.");
                e.printStackTrace();
                return;
            }

            // method tests
            try {
                Method method = Client.class.getDeclaredMethod("createLogin");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your createLogin class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method createLogin in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method createLogin in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("createAccountGUI");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your createAccountGUI class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method createAccountGUI in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method createAccountGUI in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("homeScreen");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your homeScreen class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method homeScreen in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method homeScreen in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("editProfileScreen",
                        String.class, String.class, String.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your editProfileScreen class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method editProfileScreen in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method editProfileScreen in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("followerScreen");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your followerScreen class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method followerScreen in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method followerScreen in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("followingScreen");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your followerScreen class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method followingScreen in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method followingScreen in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("requests");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your requests class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method requests in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method requests in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("requested");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your requested class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method requested in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method requested in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("viewProfileScreen",
                        String.class, String.class, String.class, String.class,
                        String.class, String.class, int.class, int.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your viewProfileScreen class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method viewProfileScreen in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method viewProfileScreen in class Client that is public, " +
                        "takes six String and two int parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Client.class.getDeclaredMethod("searchAccountScreen");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your searchAccountScreen class in Client returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method searchAccountScreen in class Client is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method searchAccountScreen in class Client that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
        }

        @Test(timeout = 1000)
        public void serverTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Server.class;
            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            try {
                Class<?> aClass = Class.forName("Server");
            } catch (ClassNotFoundException e) {
                fail("Make sure Server is a class");
            }
            assertFalse("Ensure that 'Server' is NOT abstract", Modifier.isAbstract(modifiers));
            assertTrue("Ensure that 'Server' is public!", Modifier.isPublic(modifiers));
            assertEquals("Ensure that 'Server' implements Runnable", superinterfaces.length, 1);
            assertEquals("Ensure that 'Server' implements Runnable.", superinterfaces[0], Runnable.class);
            assertEquals("Ensure that 'Sever' class does NOT extend any other class!", superclass, Object.class);

            // field tests
            Field[] fields = Server.class.getDeclaredFields();
            if (fields.length < 3) {
                fail("Ensure that you have implemented the two required fields!");
                return;
            }
            try {
                Field socket = Server.class.getDeclaredField("socket");
                if (socket.getType() != Socket.class) {
                    fail("Ensure that your field socket in class Server is of type Socket!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field socket in class Server that is of type Socket.");
                e.printStackTrace();
                return;
            }
            try {
                Field am = Server.class.getDeclaredField("am");
                if (am.getType() != AccountManager.class) {
                    fail("Ensure that your field am in class Server is of type AccountManager.");
                    return;
                }
                if (am.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                    fail("Ensure that your field am in class Server is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field am in class Server that is of type AccountManager and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field numClients = Server.class.getDeclaredField("numClients");
                if (numClients.getType() != int.class) {
                    fail("Ensure that your field numClients in class Server is of type int.");
                    return;
                }
                if (numClients.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field numClients in class Server is private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field numClients in class Server that is of type int and is private.");
                e.printStackTrace();
                return;
            }

            // method tests
            try {
                Constructor<Server> constructor = Server.class.getDeclaredConstructor(Socket.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class Server is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes a socket parameter and is public " +
                        "in class Server");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Server.class.getDeclaredMethod("run");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure tha your method run in class Server returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method run in class Server is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method run in class Server that is public, " +
                        "takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
        }

        @Test(timeout = 1000)
        public void accountManagerTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = AccountManager.class;
            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            try {
                Class<?> aClass = Class.forName("AccountManager");
            } catch (ClassNotFoundException e) {
                fail("Make sure AccountManager is a class");
            }
            assertFalse("Ensure that 'AccountManager' is NOT abstract", Modifier.isAbstract(modifiers));
            assertTrue("Ensure that 'AccountManager' is public!", Modifier.isPublic(modifiers));
            assertEquals("Ensure that 'AccountManager' class does NOT implement any interfaces!",
                    superinterfaces.length, 0);
            assertEquals("Ensure that 'AccountManager' class does NOT extend any other class!",
                    superclass, Object.class);

            // field tests
            Field[] fields = AccountManager.class.getDeclaredFields();
            if (fields.length < 2) {
                fail("Ensure that you have implemented the two required fields!");
                return;
            }
            try {
                Field accounts = AccountManager.class.getDeclaredField("accounts");
                if (accounts.getType() != ArrayList.class) {
                    fail("Ensure that your field accounts in class AccountManager is of type ArrayList!");
                    return;
                }
                if (accounts.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field accounts in class AccountManager is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field accounts in class AccountManager that is of type " +
                        "ArrayList and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field filename = AccountManager.class.getDeclaredField("filename");
                if (filename.getType() != String.class) {
                    fail("Ensure that your field filename in class AccountManager is of type String!");
                    return;
                }
                if (filename.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field filename in class AccountManager is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field filename in class AccountManager thar is of type String " +
                        "and is private!");
                e.printStackTrace();
                return;
            }


            //method tests
            try {
                Constructor<AccountManager> constructor = AccountManager.class.getDeclaredConstructor(String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes no parameters and is public in class " +
                        "AccountManager");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("readAccountsFromFile");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your readAccountsFromFile class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method readAccountsFromFile in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method readAccountsFromFile in class AccountManager " +
                        "that is public, takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("writeAccountsToFile");
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your writeAccountsToFile class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method writeAccountsToFile in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method writeAccountsToFile in class AccountManager " +
                        "that is public, takes no parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("getAccounts");
                if (!method.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getAccounts class in AccountManager returns an ArrayList!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getAccounts in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getAccounts in class AccountManager that is public, " +
                        "takes no parameters, and returns an ArrayList!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("addAccount", Account.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your addAccount class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method addAccount in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method addAccount in class AccountManager that is public, " +
                        "takes an Account parameter, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("deleteAccount", Account.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your deleteAccount class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method deleteAccount in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method deleteAccount in class AccountManager that is public, " +
                        "takes qn Account parameter, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("getAccountFromUsername", String.class);
                if (!method.getReturnType().equals(Account.class)) {
                    fail("Ensure that your getAccountFromUsername class in AccountManager returns an Account!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getAccountFromUsername in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getAccountFromUsername in class AccountManager " +
                        "that is public, takes a String parameter, and returns an Account!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("sendFollowRequest",
                        Account.class, Account.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your sendFollowRequest class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method sendFollowRequest in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method sendFollowRequest in class AccountManager " +
                        "that is public, takes two Account parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("sendFollowRequest",
                        Account.class, Account.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your unsendFollowRequest class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method unsendFollowRequest in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method unsendFollowRequest in class AccountManager that is public, " +
                        "takes two Account parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("acceptFollowRequest",
                        Account.class, Account.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your acceptFollowRequest class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method acceptFollowRequest in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method acceptFollowRequest in class AccountManager " +
                        "that is public, takes two Account parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("rejectFollowRequest",
                        Account.class, Account.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your rejectFollowRequest class in AccountManager returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method rejectFollowRequest in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method rejectFollowRequest in class AccountManager that is public, " +
                        "takes two Account parameters, and returns void!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = AccountManager.class.getDeclaredMethod("verifyAccount", String.class,
                        String.class);
                if (!method.getReturnType().equals(boolean.class)) {
                    fail("Ensure that your verifyAccount class in AccountManager returns a Boolean!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method verifyAccount in class AccountManager is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method verifyAccount in class AccountManager that is public, " +
                        "takes two String parameters, and returns a Boolean!");
                e.printStackTrace();
                return;
            }

            //ImplementationTests
            AccountManager am = new AccountManager("fileName");
            Account account = new Account("myUsername", "myPassword",
                    "My Name", "me@purdue.edu");
            Account account2 = new Account("myUsername", "myPassword",
                    "My Name", "me@purdue.edu");
            am.addAccount(account);
            am.addAccount(account2);
            if (am.getAccounts().size() != 2) {
                fail("Ensure that your method addAccount in class AccountManager correctly adds an Account.");
                return;
            }
            if (am.getAccounts().size() != 2) {
                fail("Ensure that your method getAccounts in class AccountManager returns the correct ArrayList.");
                return;
            }
            am.deleteAccount(account2);
            if (am.getAccounts().size() != 1) {
                fail("Ensure that your method deleteAccount in class AccountManager correctly deletes an Account.");
                return;
            }
            am.addAccount(account2);
            try {
                Account account3 = am.getAccountFromUsername("myUsername");
            } catch (AccountNotFoundException e) {
                fail("Ensure that your method getAccountFromUsername in class AccountManager works correctly. ");
                return;
            }
            Account friend1 = new Account("myFriend", "password",
                    "My Friend", "girl@purdue.edu");
            am.sendFollowRequest(friend1, account);
            if (account.getRequestsMe().size() != 1) {
                fail("Ensure that your method sendFollowerRequest in class AccountManager works correctly.");
                return;
            }
            try {
                am.verifyAccount("myUsername", "myPassword");
            } catch (AccountNotFoundException e) {
                fail("Ensure your method verifyAccount in class AccountManager works correctly.");
                return;
            }
            try {
                am.verifyAccount("notAnAccount", "nope");
                fail("Ensure that your method verifyAccount in class AccountManager works correctly.");
                return;
            } catch (AccountNotFoundException e) {
            }
            try {
                am.getAccountFromUsername("notAnAccount");
                fail("Ensure that your method AccountFromUsername in class AccountManager works correctly.");
                return;
            } catch (AccountNotFoundException e) {
            }
            am.acceptFollowRequest(friend1, account);
            if (friend1.getFollowers().size() != 1) {
                fail("Ensure that your method acceptFollowRequest in class AccountManager works correctly.");
                return;
            }
            am.sendFollowRequest(account, friend1);
            am.rejectFollowRequest(account, friend1);
            if (account.getFollowers().size() != 0) {
                fail("Ensure that your method rejectFollowRequest in class AccountManager works correctly.");
                return;
            }
            am.sendFollowRequest(account, account2);
            am.unsendFollowRequest(account, account2);
            if (account.getRequestsMe().size() != 0) {
                fail("Ensure that your method unsendFollow request in class AccountManager works correctly.");
                return;
            }
        }

        @Test(timeout = 1000)
        public void accountTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Account.class;
            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            try {
                Class<?> aClass = Class.forName("Account");
            } catch (ClassNotFoundException e) {
                fail("Make sure Account is a class");
            }

            assertFalse("Ensure that 'Account' is NOT abstract", Modifier.isAbstract(modifiers));
            assertTrue("Ensure that 'Account' is public!", Modifier.isPublic(modifiers));
            assertEquals("Ensure that 'Account' class implements Serializable!", superinterfaces.length, 1);
            assertEquals("Ensure that 'Account' implements Serializable.", superinterfaces[0], Serializable.class);
            assertEquals("Ensure that 'Account' class does NOT extend any other class!", superclass, Object.class);

            //Field Tests
            Field[] fields = Account.class.getDeclaredFields();
            if (fields.length < 12) {
                fail("Ensure that you have implemented the twelve required fields!");
                return;
            }
            try {
                Field username = Account.class.getDeclaredField("username");
                if (username.getType() != String.class) {
                    fail("Ensure that your field username in class Account is of type String!");
                    return;
                }
                if (username.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field username in class Account is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field username in class Account that is of type String, " +
                        "is final and private.");
                e.printStackTrace();
                return;
            }
            try {
                Field password = Account.class.getDeclaredField("password");
                if (password.getType() != String.class) {
                    fail("Ensure that your field password in class Account is of type String!");
                    return;
                }
                if (password.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field password in class Account is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field password in class Account that is of type String, " +
                        "is final and private.");
                e.printStackTrace();
                return;
            }
            try {
                Field fullName = Account.class.getDeclaredField("fullName");
                if (fullName.getType() != String.class) {
                    fail("Ensure that your field fullName in class Account is of type String!");
                    return;
                }
                if (fullName.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field fullName in class Account is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field fullName in class Account that is of type String, " +
                        "is final and private.");
                e.printStackTrace();
                return;
            }
            try {
                Field email = Account.class.getDeclaredField("email");
                if (email.getType() != String.class) {
                    fail("Ensure that your field email in class Account is of type String!");
                    return;
                }
                if (email.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field email in class Account is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you hve a field email in class Account that is of type String, " +
                        "is final and private.");
                e.printStackTrace();
                return;
            }
            try {
                Field homeTown = Account.class.getDeclaredField("homeTown");
                if (homeTown.getType() != String.class) {
                    fail("Ensure that your field homeTown in class Account is of type String!");
                    return;
                }
                if (homeTown.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field homeTown in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field homeTown in class Account that is of type " +
                        "String and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field contactInformation = Account.class.getDeclaredField("contactInformation");
                if (contactInformation.getType() != String.class) {
                    fail("Ensure that your field contactInformation in class Account is of type String!");
                    return;
                }
                if (contactInformation.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field contactInformation in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contactInformation in class Account that is of " +
                        "type String and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field interests = Account.class.getDeclaredField("interests");
                if (interests.getType() != String.class) {
                    fail("Ensure that your field interests in class Account is of type String!");
                    return;
                }
                if (interests.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field interests in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interests in class Account that is of type " +
                        "String and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field aboutMe = Account.class.getDeclaredField("aboutMe");
                if (aboutMe.getType() != String.class) {
                    fail("Ensure that your field aboutMe in class Account is of type String!");
                    return;
                }
                if (aboutMe.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field aboutMe in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field aboutMe in class Account that is of type " +
                        "String and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field followers = Account.class.getDeclaredField("followers");
                if (followers.getType() != ArrayList.class) {
                    fail("Ensure that your field followers in class Account is of type ArrayList!");
                    return;
                }
                if (followers.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field followers in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field followers in class Account that is of " +
                        "type ArrayList and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field following = Account.class.getDeclaredField("following");
                if (following.getType() != ArrayList.class) {
                    fail("Ensure that your field following in class Account is of type ArrayList!");
                    return;
                }
                if (following.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field following in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field following in class Account that is of " +
                        "type ArrayList and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field requestsMe = Account.class.getDeclaredField("requestsMe");
                if (requestsMe.getType() != ArrayList.class) {
                    fail("Ensure that your field requestsMe in class requestsMe is of type ArrayList!");
                    return;
                }
                if (requestsMe.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field requestsMe in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field requestsMe in class Account that is of type " +
                        "ArrayList and is private.");
                e.printStackTrace();
                return;
            }
            try {
                Field meRequested = Account.class.getDeclaredField("meRequested");
                if (meRequested.getType() != ArrayList.class) {
                    fail("Ensure that your field meRequested in class Account is of type ArrayList!");
                    return;
                }
                if (meRequested.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your field meRequested in class Account is private!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field meRequested in class Account that is of " +
                        "type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            //method tests
            try {
                Constructor<Account> constructor =
                        Account.class.getDeclaredConstructor(String.class, String.class, String.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes four String parameters and is " +
                        "public in class Account.");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getFollowers");
                if (!method.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your method getFollowers in class Account returns an ArrayList!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFollowers in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getFollowers in class Account that is public, " +
                        "returns an ArrayList, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("numFollowers");
                if (!method.getReturnType().equals(int.class)) {
                    fail("Ensure that your method numFollowers in class Account returns an int!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method numFollowers in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method numFollowers in class Account that is public, " +
                        "returns an int, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("numFollowing");
                if (!method.getReturnType().equals(int.class)) {
                    fail("Ensure that your method numFollowing in class Account returns an int!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method numFollowing in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method numFollowing in class Account that is public, " +
                        "returns an int, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getUsername");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getUsername in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getUsername in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getUsername in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getPassword");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getPassword in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getPassword in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getPassword in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getFullName");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getFullName in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFullName in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getFullName in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getHomeTown");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getHomeTown in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getHomeTown in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getHomeTown in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getEmail");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getEmail in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getEmail in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getEmail in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getContactInformation");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getContactInformation in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getContactInformation in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getContactInformation in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getInterests");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getInterests in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getInterests in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getInterests in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getFollowing");
                if (!method.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your method getFollowing in class Account returns an ArrayList!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFollowing in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getFollowing in class Account that is public, " +
                        "returns an ArrayList, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getRequestsMe");
                if (!method.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your method getRequestsMe in class Account returns an ArrayList!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getRequestsMe in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getRequestsMe in class Account that is public, " +
                        "returns an ArrayList, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getMeRequested");
                if (!method.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your method getMeRequested in class Account returns an ArrayList!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getMeRequested in class Account is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getMeRequested in class Account that is public, " +
                        "returns an ArrayList, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getAboutMe");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getAboutMe in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getAboutMe in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getAboutMe in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getProfile");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getProfile in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getProfile in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getProfile in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("getAboutMe");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getAboutMe in class Account returns a String!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getAboutMe in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getAboutMe in class Account that is public, " +
                        "returns a String, and takes no parameters!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("setContactInformation", String.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your method setContactInformation in class Account returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setContactInformation in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getAboutMe in class Account that is public, " +
                        "returns void , and takes a String parameter!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("setHomeTown", String.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your method setHomeTown in class Account returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setHomeTown in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method setHomeTown in class Account that is public, " +
                        "returns void , and takes a String parameter!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("setInterests", String.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your method setInterests in class Account returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setInterests in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method setInterests in class Account that is public, " +
                        "returns void , and takes a String parameter!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = Account.class.getDeclaredMethod("setAboutMe", String.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your method setAboutMe in class Account returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setAboutMe in class Account is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method setAboutMe in class Account that is public, returns void , " +
                        "and takes a String parameter!");
                e.printStackTrace();
                return;
            }

            //Implementation Test
            Account account = new Account("myUsername", "myPassword",
                    "my name", "me@purdue.edu");
            String username = account.getUsername();
            if (!username.equals("myUsername")) {
                fail("Ensure that your method getUsername in class Account returns the correct value. " +
                        "Expected 'myUsername', but was " + username);
                return;
            }
            String password = account.getPassword();
            if (!password.equals("myPassword")) {
                fail("Ensure that your method getPassword in class Account returns the correct value. " +
                        "Expected 'myPassword', but was " + password);
                return;
            }
            String name = account.getFullName();
            if (!name.equals("my name")) {
                fail("Ensure that your method getFullName in class Account returns the correct value. " +
                        "Expected 'my name', but was " + name);
                return;
            }
            String email = account.getEmail();
            if (!email.equals("me@purdue.edu")) {
                fail("Ensure that your method getEmail in class Account returns the correct value. " +
                        "Expected 'me@purdu.edu', but was " + email);
                return;
            }
            account.setAboutMe("Stuff about me.");
            String aboutMe = account.getAboutMe();
            if (!aboutMe.equals("Stuff about me.")) {
                fail("Ensure that your method setAboutMe in class Account sets the correct value. " +
                        "Expected 'Stuff about me.', but was " + aboutMe);
                return;
            }
            if (!aboutMe.equals("Stuff about me.")) {
                fail("Ensure that your method getAboutMe in class Account returns that correct value. " +
                        "Expected 'Stuff about me.', but was " + aboutMe);
                return;
            }
            account.setContactInformation("(xxx)xxx-xxxx");
            String contactInfo = account.getContactInformation();
            if (!contactInfo.equals("(xxx)xxx-xxxx")) {
                fail("Ensure that your method setContactInformation in class Account sets the correct value. " +
                        "Expected '(xxx)xxx-xxxx', but was " + contactInfo);
                return;
            }
            if (!contactInfo.equals("(xxx)xxx-xxxx")) {
                fail("Ensure that your method getContactInformation in class Account returns that correct value. " +
                        "Expected '(xxx)xxx-xxxx', but was " + contactInfo);
                return;
            }
            account.setHomeTown("Chicago");
            String homeTown = account.getHomeTown();
            if (!homeTown.equals("Chicago")) {
                fail("Ensure that your method setHometown in class Account sets the correct value. " +
                        "Expected 'Chicago', but was " + homeTown);
                return;
            }
            if (!homeTown.equals("Chicago")) {
                fail("Ensure that your method getHometown in class Account returns that correct value. " +
                        "Expected 'Chicago', but was " + homeTown);
                return;
            }
            String profile = account.getProfile();
            String correctProfile = "";
            correctProfile += "Username: " + account.getUsername() + "\n";
            correctProfile += "Full name: " + account.getFullName() + "\n";
            correctProfile += "Home town: " + account.getHomeTown() + "\n";
            correctProfile += "Email: " + account.getEmail() + "\n";
            correctProfile += "Username: " + account.getUsername() + "\n";
            correctProfile += "Contact info: " + account.getContactInformation() + "\n";
            correctProfile += "About me: " + account.getAboutMe() + "\n";
            if (!profile.equals(correctProfile)) {
                fail("Ensure that your method getProfile in class Account returns the correct value.");
                return;
            }
            account.setInterests("I like coding!");
            String interests = account.getInterests();
            if (!interests.equals("I like coding!")) {
                fail("Ensure that your method getInterests in class Account returns that correct value. " +
                        "Expected 'I like coding!', but was " + interests);
                return;
            }
            if (!interests.equals("I like coding!")) {
                fail("Ensure that your method setInterests in class Account sets the correct value. " +
                        "Expected 'I like coding!', but was " + interests);
                return;
            }
            account.setHomeTown("Indy");
            homeTown = account.getHomeTown();
            if (!account.getHomeTown().equals("Indy")) {
                fail("Ensure that your method setHomeTown in class Account sets the correct value. " +
                        "Expected 'Indy', but was" + homeTown);
                return;
            }
            Account friend1 = new Account("myFriend", "password", "My Friend",
                    "girl@purdue.edu");
            AccountManager am = new AccountManager("filename");
            am.sendFollowRequest(friend1, account);
            am.acceptFollowRequest(friend1, account);
            if (account.getRequestsMe().size() != 1) {
                fail("Ensure that your method getRequestsMe in class Account returns the correct ArrayList.");
                return;
            }
            if (account.getRequestsMe().get(0).getUsername() != "myFriend") {
                fail("Ensure that your method getRequestsMe in class Account returns the correct ArrayList.");
                return;
            }
            if (friend1.getMeRequested().size() != 1) {
                fail("Ensure that your method getMeRequested in class Account returns the correct ArrayList");
                return;
            }
            if (friend1.getMeRequested().get(0).getUsername() != "myUsername") {
                fail("Ensure that your method getMeRequested in class Account returns the correct ArrayList");
                return;
            }
            am.sendFollowRequest(account, friend1);
            am.acceptFollowRequest(account, friend1);
            if (account.getFollowers().size() != 1) {
                fail("Ensure that your method getFollowers in class Account returns the correct ArrayList");
                return;
            }
            if (account.numFollowers() != 1) {
                fail("Ensure that your method numFollowers in class Account returns the correct size.");
                return;
            }
            if (account.numFollowing() != 1) {
                fail("Ensure that your method numFollowing in class Account returns the correct size.");
                return;
            }
            if (account.getFollowing().size() != 1) {
                fail("Ensure that your method getFollowing in class Account returns the correct size.");
                return;
            }
        }

        @Test(timeout = 1000)
        public void exceptionTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = AccountNotFoundException.class;
            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            try {
                Class<?> aClass = Class.forName("AccountNotFoundException");
            } catch (ClassNotFoundException e) {
                fail("Make sure AccountNotFoundException is a class");
            }
            assertFalse("Ensure that 'AccountNotFoundException' is NOT abstract", Modifier.isAbstract(modifiers));
            assertTrue("Ensure that 'AccountNotFoundException' is public!", Modifier.isPublic(modifiers));
            assertEquals("Ensure that 'AccountNotFoundException' extends 'Exception'", superclass, Exception.class);
            assertEquals("Ensure that 'AccountNotFoundException' class does NOT implement any interfaces!",
                    superinterfaces.length, 0);
            try {
                Constructor<AccountNotFoundException> constructor =
                        AccountNotFoundException.class.getDeclaredConstructor();
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class AccountNotFoundException is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes no parameters and is public in " +
                        "class AccountNotFoundException.");
                e.printStackTrace();
                return;
            }
            try {
                Constructor<AccountNotFoundException> constructor =
                        AccountNotFoundException.class.getDeclaredConstructor(String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class AccountNotFoundException is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes a String parameters and is public in " +
                        "class AccountNotFoundException.");
                e.printStackTrace();
                return;
            }
            // Implementation Test
            AccountManager am = new AccountManager("Data.txt");
            Account account = new Account("username", "pass", "My Name",
                    "email@purdue.edu");
            am.addAccount(account);
            try {
                am.getAccountFromUsername("not an account");
                fail("Ensure that your AccountNotFoundException works correctly!");
            } catch (AccountNotFoundException e) {
            }


        }

        @Test(timeout = 1000)
        public void inputOutputTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = InputOutput.class;
            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            try {
                Class<?> aClass = Class.forName("InputOutput");
            } catch (ClassNotFoundException e) {
                fail("Make sure InputOutput is a class");
            }
            assertFalse("Ensure that 'InputOutput' is NOT abstract", Modifier.isAbstract(modifiers));
            assertTrue("Ensure that 'InputOutput' is public!", Modifier.isPublic(modifiers));
            assertEquals("Ensure that 'InputOutput' does NOT extend any other classes", superclass, Object.class);
            assertEquals("Ensure that 'AccountNotFoundException' class does NOT implement any interfaces!",
                    superinterfaces.length, 0);

            // Method Tests
            try {
                Method method = InputOutput.class.getDeclaredMethod("readAccountsFromFile", String.class);
                if (!method.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your readAccountsFromFile class in InputOutput returns an ArrayList!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method readAccountsFromFile in class InputOutput is public and static!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method readAccountsFromFile in class InputOutput that is " +
                        "public and static, takes a String parameter, and returns an ArrayList!");
                e.printStackTrace();
                return;
            }
            try {
                Method method = InputOutput.class.getDeclaredMethod("writeAccountsToFile",
                        ArrayList.class, String.class);
                if (!method.getReturnType().equals(void.class)) {
                    fail("Ensure that your writeAccountsToFile class in InputOutput returns void!");
                    return;
                }
                if (method.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method writeAccountsToFile in class InputOutput is public and static!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method writeAccountsToFile in class InputOutput that is public " +
                        "and static, " +
                        "takes an ArrayList and String parameter, and returns void!");
                e.printStackTrace();
                return;
            }

            //Implementation Test
            AccountManager am = new AccountManager("Data.txt");
            Account account = new Account("username", "pass", "My Name",
                    "email@purdue.edu");
            am.addAccount(account);
            try {
                am.writeAccountsToFile();
                am.readAccountsFromFile();
                if (!am.getAccounts().get(0).getUsername().equals("username")) {
                    fail("Ensure your methods readAccountsFromFile and writeAccountsToFile work correctly.");
                    return;
                }
            } catch (IOException e) {
                fail("Ensure your methods readAccountsFromFile and writeAccountsToFile work correctly.");
                e.printStackTrace();
                return;
            } catch (ClassNotFoundException e) {
                fail("Ensure your methods readAccountsFromFile and writeAccountsToFile work correctly.");
                e.printStackTrace();
                return;
            }
        }

    }
}
