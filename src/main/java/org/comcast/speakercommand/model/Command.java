package org.comcast.speakercommand.model;

public class Command {
    private String speaker;
    private String command;

    public Command(String speaker, String command) {
        this.speaker = speaker;
        this.command = command;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getCommand() {
        return command;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
