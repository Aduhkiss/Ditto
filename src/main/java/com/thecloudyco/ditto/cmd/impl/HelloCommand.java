package com.thecloudyco.ditto.cmd.impl;

import com.thecloudyco.ditto.cmd.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class HelloCommand extends Command {
    public HelloCommand() {
        super("hello", "Example Command", "ditto.command.hello");
    }

    @Override
    public void execute(String[] args, JDA discord, MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Title", null);

        eb.setColor(Color.red);
        eb.setColor(new Color(0xF40C0C));
        eb.setColor(new Color(255, 0, 54));

        eb.setDescription("Text");
        eb.addField("Title of field", "test of field", false);
        eb.addBlankField(false);
        eb.setAuthor("name", null, "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");
        eb.setFooter("Text", "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");
        eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
        eb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");

        event.getTextChannel().sendMessageEmbeds(eb.build()).queue();
    }
}
