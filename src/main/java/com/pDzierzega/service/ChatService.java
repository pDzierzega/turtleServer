package com.pDzierzega.service;

import com.pDzierzega.model.AppUser;

import java.util.List;

public interface ChatService {
    void sendToUsers(List<AppUser> userList);
}
