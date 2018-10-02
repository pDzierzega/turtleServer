package com.pDzierzega.service.impl;

import com.pDzierzega.model.GameBoard;
import com.pDzierzega.repository.GameBoardRepository;
import com.pDzierzega.service.GameBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameBoardServiceImpl implements GameBoardService {

    private GameBoardRepository repository;

    @Autowired
    public GameBoardServiceImpl(GameBoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public GameBoard create() {
        GameBoard gameBoard=new GameBoard();
        return repository.save(gameBoard);
    }
}
