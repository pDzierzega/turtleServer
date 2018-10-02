package com.pDzierzega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:4200")
public class RestSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    public RestSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @PostMapping("/send")
    public String newUser (@RequestBody String token){
        template.convertAndSend("/topic/reply",token);
        return token;
    }
}
