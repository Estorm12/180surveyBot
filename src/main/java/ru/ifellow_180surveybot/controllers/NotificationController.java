package ru.ifellow_180surveybot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

//    private final TelegramBot telegramBot;
//
//    @PostMapping("/state")
//    public void sendState(@RequestBody StateWHDto stateWHDto){
//        telegramBot.sendNewStateMessage(stateWHDto);
//    }
//
//    @PostMapping("/event")
//    public void sendEvent(@RequestBody EventWHDto eventWHDto){
//        telegramBot.sendEventMessage(eventWHDto);
//    }
}
