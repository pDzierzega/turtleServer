package com.pDzierzega.controller;

import com.pDzierzega.DTO.GameDTO;
import com.pDzierzega.mapper.GameMapper;
import com.pDzierzega.model.Game;
import com.pDzierzega.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    private GameService service;
    private GameMapper mapper;

    @Autowired
    public GameController(GameService service, GameMapper mapper) {
        this.service = service;
        this.mapper=mapper;
    }

    @PostMapping("/create/{uuid}")
    public String createGame(@PathVariable String uuid){
        Game game=service.create(uuid);
        return game.getUuid();
    }

}
