package org.comcast.speakercommand.service;

import org.comcast.speakercommand.model.Command;
import org.comcast.speakercommand.model.MostFrequentCommand;
import org.comcast.speakercommand.model.StateCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TopCommandsServiceImp implements TopCommandsService{
    @Value("topCommandsNationally")
    private String topCommandsNationally;

    @Override
    public Map getTopCommands(Long startProcessTime, Map<String, List<Command>> stateCommandsRequest){
        Map<String, Object> statesTopCommands = new HashMap<>();
        List<StateCommands> statesCommands = getStatesCommands(stateCommandsRequest);

        statesCommands.stream().forEach(stateCommands ->{
            List<Command> commands = stateCommands.getCommands();
            String topStateCommand = commands.stream().collect(Collectors.groupingBy(command -> command.getCommand(), Collectors.counting()))
            .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
            .get().getKey();
            MostFrequentCommand stateMostFreqCommand = new MostFrequentCommand();
            stateMostFreqCommand.setMostFrequentCommand(topStateCommand);
            stateMostFreqCommand.setStartProcessTime(startProcessTime);
            stateMostFreqCommand.setStopProcessTime(System.currentTimeMillis());
            statesTopCommands.put(stateCommands.getStateName(),stateMostFreqCommand);
        });
        statesTopCommands.put(topCommandsNationally, getTopCommandsNationally(statesCommands));
        return statesTopCommands;
    }
    @Override
    public List<String> getTopCommandsNationally(List<StateCommands> stateCommands){
        List<Command> allCommands =  new ArrayList<>();
        stateCommands.forEach(stateCommand -> {
                    stateCommand.getCommands().forEach(command ->
                            allCommands.add(command));
        });

        List<String>  topThreeCommands = allCommands.stream().collect(Collectors.groupingBy(command -> command.getCommand(),() -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(3).collect(Collectors.toList());

        return topThreeCommands;
    }
    @Override
    public  List<StateCommands> getStatesCommands(Map<String, List<Command>> stateCommandsRequest){
        List<StateCommands> statesCommands = new ArrayList<>();
        stateCommandsRequest.forEach((stateName, commands) -> {
                    StateCommands stateCommands = new StateCommands();
                    stateCommands.setStateName(stateName.toLowerCase());
                    stateCommands.setCommands(commands);
                    statesCommands.add(stateCommands);
                }
        );
        return statesCommands;
    }

}
