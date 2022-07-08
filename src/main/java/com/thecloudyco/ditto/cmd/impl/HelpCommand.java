package com.thecloudyco.ditto.cmd.impl;

import com.thecloudyco.ditto.cmd.Command;
import com.thecloudyco.ditto.cmd.CommandCenter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", "DM's you a list of all the commands the bot can do", "ditto.command.help");
    }

    @Override
    public void execute(String[] args, JDA discord, MessageReceivedEvent event) {
        EmbedBuilder emb = new EmbedBuilder();
        emb.setTitle("List of Ditto Commands");
        emb.setColor(Color.PINK);

        for(Command cmd : CommandCenter.Commands) {
            emb.addField(cmd.getName(), cmd.getDescription(), true);
        }
        event.getTextChannel().sendMessageEmbeds(emb.build()).queue();

        return;
    }
}
