package com.pDzierzega.service.impl;


import com.pDzierzega.bootstrap.Color;
import com.pDzierzega.model.*;
import com.pDzierzega.repository.PlayerRepository;
import com.pDzierzega.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository repository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Player> createPlayerList(List<AppUser> userList) {

        List<Color> colorList= Arrays.asList(Color.values());
        Collections.shuffle(colorList);

        List<Player> playerList=new ArrayList<>();

        for (int i = 0; i <userList.size() ; i++) {
            Player player=new Player();
            player.setUser(userList.get(i));
            player.setColor(colorList.get(i));
//            player.setGame(game);
        }

        return repository.saveAll(playerList);
    }
}
