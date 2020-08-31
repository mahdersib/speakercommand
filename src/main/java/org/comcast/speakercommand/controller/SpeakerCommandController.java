package org.comcast.speakercommand.controller;
import org.comcast.speakercommand.model.Command;
import org.comcast.speakercommand.model.MostFrequentCommand;
import org.comcast.speakercommand.service.TopCommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SpeakerCommandController {

    @Autowired
    TopCommandsService topCommandsService;

    @PostMapping("/top-commands")
    public Map topSpeakerCommands(@RequestBody Map<String, List<Command>> stateCommandsRequest) {
        Long startProcessTime = System.currentTimeMillis();
        return topCommandsService.getTopCommands(startProcessTime, stateCommandsRequest);
    }


//    public Map topSpeakerCommands(@RequestBody StateCommands stateCommands){
//        MostFrequentCommand mostFrequentCommand = new MostFrequentCommand("CNN",456777,55667);
//        Map<String, Object> stateMap = new HashMap<>();
//        stateMap.put("Alabama",mostFrequentCommand);
//        stateMap.put("Virginia",mostFrequentCommand);
//
//        stateMap.put("topCommandsNationally", Arrays.asList("CNN","GGAG"));
//        return stateMap;
//    }
//    public TopCommands topSpeakerCommands(@RequestBody StateCommands stateCommands){
//        TopCommands topCommands = new TopCommands();
//        MostFrequentCommand mostFrequentCommand = new MostFrequentCommand("CNN",456777,55667);
//        Map<String, MostFrequentCommand> stateMap = new HashMap<>();
//        stateMap.put("Alabama",mostFrequentCommand);
//        stateMap.put("Virginia",mostFrequentCommand);
//
//
//        topCommands.setStatesMostFrequentCommand(stateMap);
//
//
//        topCommands.setTopCommandsNationally(Arrays.asList("CNN","GGAG"));
//
//        return topCommands;
//    }
}
