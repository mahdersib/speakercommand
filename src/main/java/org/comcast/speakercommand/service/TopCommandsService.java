package org.comcast.speakercommand.service;

import org.comcast.speakercommand.model.Command;
import org.comcast.speakercommand.model.StateCommands;

import java.util.List;
import java.util.Map;

public interface TopCommandsService {
    Map getTopCommands(Long startProcessTime, Map<String, List<Command>> stateCommandsRequest);
    List<String> getTopCommandsNationally(List<StateCommands> stateCommands);
    List<StateCommands> getStatesCommands(Map<String, List<Command>> stateCommandsRequest);
}
