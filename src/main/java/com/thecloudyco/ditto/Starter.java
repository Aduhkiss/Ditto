package com.thecloudyco.ditto;

import com.thecloudyco.ditto.cmd.CommandCenter;
import com.thecloudyco.ditto.database.CoreDatabase;
import com.thecloudyco.ditto.util.LogUtil;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class Starter {

    private static JDABuilder discord;

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Dotenv dotenv = Dotenv.load();
        discord = JDABuilder.createDefault(dotenv.get("DISCORD_TOKEN"));
        discord.setBulkDeleteSplittingEnabled(false);
        discord.setActivity(Activity.watching("you sleep"));

        // Setup the connection to the MySQL Database
        try {
            CoreDatabase.getInstance().connect();
        } catch (SQLException e) {
            LogUtil.severe("Unable to communicate with the database! Program has to shut down now...");
            System.exit(1);
        }

        // Get all of the pre-built commands in mem and registered to the api
        CommandCenter.registerCommands();
        discord.addEventListeners(new CommandCenter());

        try {
            discord.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
