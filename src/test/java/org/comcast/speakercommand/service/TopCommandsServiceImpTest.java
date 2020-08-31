package org.comcast.speakercommand.service;

import org.comcast.speakercommand.model.Command;
import org.comcast.speakercommand.model.MostFrequentCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TopCommandsServiceImpTest {
    @InjectMocks
    private TopCommandsServiceImp topCommandsServiceImp;

    @Test
    public void getTopCommands(){
        Map<String, List<Command>> stateCommandsRequest = new HashMap<>();
        stateCommandsRequest.put("Alabama", Arrays.asList(new Command("Fred Zhang", "CNN"),
                new Command("Fred Zhang", "Stranger Things"),
                new Command("Fred Zhang", "CNN")));
        stateCommandsRequest.put("Virginia", Arrays.asList(new Command("Thomas Brown", "Show me movies"),
                new Command("Fred Zhang", "Stranger Things"),
                new Command("Thomas Brown", "Show me movies")));

        Map<String, Object> statesTopCommands = new HashMap<>();

        MostFrequentCommand mostFreqCommandAlabama = new MostFrequentCommand();
        mostFreqCommandAlabama.setStopProcessTime(12345);
        mostFreqCommandAlabama.setStartProcessTime(12345);
        mostFreqCommandAlabama.setMostFrequentCommand("CNN");

        MostFrequentCommand mostFreqCommandVirginia = new MostFrequentCommand();
        mostFreqCommandVirginia.setStopProcessTime(12345);
        mostFreqCommandVirginia.setStartProcessTime(12345);
        mostFreqCommandVirginia.setMostFrequentCommand("Show me movies");

        statesTopCommands.put("alabama", mostFreqCommandAlabama);
        statesTopCommands.put("virginia", mostFreqCommandVirginia);

        statesTopCommands.put("topCommandsNationally", Arrays.asList("cnn","stranger things","show me movies"));


        Map actualStatesTopCommands = topCommandsServiceImp.getTopCommands((long) 12345, stateCommandsRequest);

        assertEquals(statesTopCommands.get("topCommandsNationally"),actualStatesTopCommands.get("topCommandsNationally"));
        MostFrequentCommand actualMostFreqCommandAlabama = (MostFrequentCommand) actualStatesTopCommands.get("alabama");
        assertEquals(mostFreqCommandAlabama.getMostFrequentCommand(),actualMostFreqCommandAlabama.getMostFrequentCommand());
        MostFrequentCommand actualMostFreqCommandVirginia= (MostFrequentCommand) actualStatesTopCommands.get("virginia");
        assertEquals(mostFreqCommandVirginia.getMostFrequentCommand(),actualMostFreqCommandVirginia.getMostFrequentCommand());

    }
}
