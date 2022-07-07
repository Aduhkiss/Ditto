package com.thecloudyco.ditto.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {
    /**
     * Helpful static class for sending messages to the console
     * @Author Atticus Zambrana
     */

    public static void info(String txt) {
        Date currentDate = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
        System.out.println("[" + df.format(currentDate) + "] (INFO) " + txt);
    }
    public static void warning(String txt) {
        Date currentDate = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
        System.out.println("[" + df.format(currentDate) + "] (WARNING) " + txt);
    }
    public static void error(String txt) {
        Date currentDate = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
        System.out.println("[" + df.format(currentDate) + "] (ERROR) " + txt);
    }
    public static void severe(String txt) {
        Date currentDate = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
        System.out.println("[" + df.format(currentDate) + "] (SEVERE) " + txt);
    }
}
