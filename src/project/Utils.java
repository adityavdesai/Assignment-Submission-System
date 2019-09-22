package project;

import javax.swing.*;

public class Utils {
    // This function shows a message dialog and exits
    static void exit(JFrame currentFrame) {
        JOptionPane.showMessageDialog(currentFrame, "Exiting!");
        System.exit(0);
    }

    // This function shows a message dialog on the current frame
    static void showMessage(JFrame currentFrame, String message) {
        JOptionPane.showMessageDialog(currentFrame, message);
    }

    /**
     * This method <i>encrypts</i> the given string
     *
     * @param s String to be encrypted
     *          Each Character of the String is XOR'd with the length of the String
     * @return String with each character XOR'd with length
     */
    static String encrypt(String s) {
        String n = "";
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            int t = c;
            t = t ^ l;
            c = (char) (t);
            n += c;
        }
        return n;
    }

    // This method decrypts the given string by calling encrypt(), as we use a very simple XOR logic for now
    static String decrypt(String s) {
        return encrypt(s);
    }

}