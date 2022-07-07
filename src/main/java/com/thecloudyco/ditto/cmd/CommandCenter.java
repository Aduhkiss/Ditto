package com.thecloudyco.ditto.cmd;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommandCenter extends ListenerAdapter {
    public static List<Command> Commands = new ArrayList<>();

    public static void registerCommands() {
        //Commands.add();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
        long time = System.currentTimeMillis();
    }
}
