package com.pDzierzega.service;

import com.pDzierzega.model.Game;

import java.security.Principal;
import java.util.List;

public interface GameService {
    Game create(String uuid);
}
