package org.comcast.speakercommand.controller;
import org.comcast.speakercommand.model.Command;
import org.comcast.speakercommand.service.TopCommandsService;
import org.comcast.speakercommand.service.TopCommandsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SpeakerCommandController {

    @Autowired
    private TopCommandsService topCommandsService;

    @PostMapping("/top-commands")
    public Map topSpeakerCommands(@RequestBody Map<String, List<Command>> stateCommandsRequest) {
        Long startProcessTime = System.currentTimeMillis();
        return topCommandsService.getTopCommands(startProcessTime, stateCommandsRequest);
    }
}
