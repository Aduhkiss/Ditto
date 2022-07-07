package com.thecloudyco.ditto.cmd;

import com.thecloudyco.ditto.cmd.impl.HelloCommand;
import com.thecloudyco.ditto.util.LogUtil;
import com.thecloudyco.ditto.util.StringUtil;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommandCenter extends ListenerAdapter {
    public static List<Command> Commands = new ArrayList<>();

    public static void registerCommands() {
        Commands.add(new HelloCommand());
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
        long time = System.currentTimeMillis();

        for(Command cmd : Commands) {
            if(msg.getContentDisplay().startsWith("!" + cmd.getName())) {
                cmd.execute(StringUtil.toArrayWithoutFirst(msg.getContentDisplay()));
                LogUtil.info(event.getAuthor().getName() + " executed " + cmd.getName());
            }
        }


        // Maybe handle if the command wasnt found??
    }
}
