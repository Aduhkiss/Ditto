package com.thecloudyco.ditto.database;

import com.thecloudyco.ditto.util.LogUtil;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CoreDatabase {
    /***
     * Singleton Class for managing all the code related to communication with the MySQL Database
     * @Author: Atticus Zambrana
     */
    private static CoreDatabase me;
    public static CoreDatabase getInstance() {
        if(me == null) {
            me = new CoreDatabase();
        }
        return me;
    }

    private boolean isConnected;
    private int disconnectTimer;
    private String queue;

    private String myHostname;
    private String myDatabase;
    private String myUsername;
    private String myPassword;

    private Connection connection = null;

    public CoreDatabase() {
        // Pull any config from the .env file, and set it in this instance
        Dotenv dotenv = Dotenv.load();
        this.myHostname = dotenv.get("MYSQL_HOSTNAME");
        this.myDatabase = dotenv.get("MYSQL_DATABASE");
        this.myUsername = dotenv.get("MYSQL_USERNAME");
        this.myPassword = dotenv.get("MYSQL_PASSWORD");
        LogUtil.info("Database setup complete. Ready to transact!");
    }

    public void connect() throws SQLException {
        if(isConnected) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LogUtil.severe("MySQL Connection Class NOT FOUND! Shutting down application...");
            System.exit(1);
        }

        connection = DriverManager.getConnection(
                "jdbc:mysql://" + myHostname + ":3306/" + myDatabase,
                myUsername, myPassword);
    }

    public void disconnect() {

    }

    public boolean isConnected () {
        return isConnected;
    }

    public int getDisconnectTimer() {
        return disconnectTimer;
    }
}
