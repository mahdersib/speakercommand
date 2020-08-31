package org.comcast.speakercommand.model;

import java.util.List;
import java.util.Map;

public class TopCommands {
    private Map<String,MostFrequentCommand> statesMostFrequentCommand;
    private List<String> topCommandsNationally;

    public Map<String, MostFrequentCommand> getStatesMostFrequentCommand() {
        return statesMostFrequentCommand;
    }

    public void setStatesMostFrequentCommand(Map<String, MostFrequentCommand> statesMostFrequentCommand) {
        this.statesMostFrequentCommand = statesMostFrequentCommand;
    }

    public List<String> getTopCommandsNationally() {
        return topCommandsNationally;
    }

    public void setTopCommandsNationally(List<String> topCommandsNationally) {
        this.topCommandsNationally = topCommandsNationally;
    }
}
