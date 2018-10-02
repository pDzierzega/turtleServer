package com.pDzierzega.service;

import com.pDzierzega.model.Card;
import com.pDzierzega.model.Game;

import java.util.List;

public interface CardService {
    List<Card> createDeck();

    void getAllPlayerFiveCards(Game game);
}
