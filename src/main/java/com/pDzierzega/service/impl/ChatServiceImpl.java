package com.pDzierzega.service.impl;

import com.pDzierzega.model.AppUser;
import com.pDzierzega.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final SimpMessagingTemplate template;

    @Autowired
    public ChatServiceImpl(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Override
    public void sendToUsers(List<AppUser> userList){
        for (AppUser appUser :userList) {
            this.template.convertAndSendToUser(appUser.getUsername(),"/topic/reply","DUPA");
        }
    }
}
