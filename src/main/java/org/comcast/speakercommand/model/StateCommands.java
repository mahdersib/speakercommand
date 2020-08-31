package org.comcast.speakercommand.model;

import java.util.List;

public class StateCommands {
    private String stateName;
    private List<Command> commands;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
