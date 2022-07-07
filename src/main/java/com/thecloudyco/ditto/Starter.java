package com.thecloudyco.ditto;

import com.thecloudyco.ditto.cmd.CommandCenter;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Starter {

    private static JDABuilder discord;

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Dotenv dotenv = Dotenv.load();
        discord = JDABuilder.createDefault(dotenv.get("DISCORD_TOKEN"));
        discord.setBulkDeleteSplittingEnabled(false);
        discord.setActivity(Activity.watching("you sleep"));

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
