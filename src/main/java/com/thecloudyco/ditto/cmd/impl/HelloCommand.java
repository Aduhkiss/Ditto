package com.thecloudyco.ditto.cmd.impl;

import com.thecloudyco.ditto.cmd.Command;

public class HelloCommand extends Command {
    public HelloCommand() {
        super("hello", "Example Command", "ditto.command.hello");
    }

    @Override
    public void execute(String[] args) {

    }
}
