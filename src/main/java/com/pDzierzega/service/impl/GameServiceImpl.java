package com.pDzierzega.service.impl;

import com.pDzierzega.model.*;
import com.pDzierzega.repository.TableRepository;
import com.pDzierzega.repository.GameRepository;
import com.pDzierzega.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository repository;
    private TableRepository builderRepository;

    private CardService cardService;
    private PlayerService playerService;
    private TurtleService turtleService;
    private GameBoardService gameBoardService;

    @Autowired
    public GameServiceImpl(GameRepository repository, TableRepository builderRepository, CardService cardService, PlayerService playerService, TurtleService turtleService, GameBoardService gameBoardService) {
        this.repository = repository;
        this.builderRepository = builderRepository;
        this.cardService = cardService;
        this.playerService = playerService;
        this.turtleService = turtleService;
        this.gameBoardService = gameBoardService;
    }

    @Override
    public Game create(String uuid) {

        GameTable builder= builderRepository.findByUuid(uuid);;
        System.out.println(builder);

        Game game= new Game();

        game.setGameBoard(gameBoardService.create());
        game.setTurtleList(turtleService.createTurtles());
        game.setDeck(cardService.createDeck());
        game.setPlayerList(playerService.createPlayerList(builder.getUserList()));

        cardService.getAllPlayerFiveCards(game);

        builderRepository.delete(builder);

        return repository.save(game);
    }



}
