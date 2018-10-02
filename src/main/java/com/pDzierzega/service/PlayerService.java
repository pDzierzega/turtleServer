package com.pDzierzega.service;

import com.pDzierzega.model.AppUser;
import com.pDzierzega.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> createPlayerList(List<AppUser> userList);
}
