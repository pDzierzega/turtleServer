package com.pDzierzega.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/message")
    @SendTo("/topic/reply")
    public String onReciveMessage(String message){

        System.out.println( );
        System.out.println(message);
        System.out.println( );

//        this.template.convertAndSend("/topic/public", message);

        return "Pozdrawia"+message;
    }
}
