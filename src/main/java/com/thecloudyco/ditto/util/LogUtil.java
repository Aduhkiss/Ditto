package com.thecloudyco.ditto.util;

public class LogUtil {
    /**
     * Helpful static class for sending messages to the console
     * @Author Atticus Zambrana
     */

    public static void info(String txt) {
        System.out.println("(INFO) " + txt);
    }
    public static void warning(String txt) {
        System.out.println("(WARNING) " + txt);
    }
    public static void error(String txt) {
        System.out.println("(ERROR) " + txt);
    }
    public static void severe(String txt) {
        System.out.println("(SEVERE) " + txt);
    }
}
