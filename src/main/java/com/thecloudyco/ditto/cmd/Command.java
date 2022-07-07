package com.thecloudyco.ditto.cmd;

public abstract class Command {

    private String name;
    private String description;
    private String permission;

    public Command(String name, String description, String permission) {
        this.name = name;
        this.description = description;
        this.permission = permission;
    }

    public Command(String name, String permission) {
        this.name = name;
        this.permission = permission;
        this.description = "(No Description Provided)";
    }

    public abstract void execute(String[] args);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }
}
