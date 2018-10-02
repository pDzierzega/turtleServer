package com.pDzierzega.service.impl;

import com.pDzierzega.bootstrap.Color;
import com.pDzierzega.model.Card;
import com.pDzierzega.model.Game;
import com.pDzierzega.model.Player;
import com.pDzierzega.repository.CardRepository;
import com.pDzierzega.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository repository;

    @Autowired
    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Card> createDeck() {
        List<Card> deck=new ArrayList<>();

        int[] moves=Color.move;

        for (Color color :Color.values()) {
            for (int i = 0; i <moves.length ; i++) {
                Card card=new Card();
                card.setColor(color);
                card.setMove(moves[i]);
            }
        }
        return repository.saveAll(deck);
    }

    @Override
    public void getAllPlayerFiveCards(Game game) {
        List<Card> cardList=game.getDeck();
        List<Player> playerList=game.getPlayerList();

        for (int i = 0; i <playerList.size() ; i++) {
            Player player=playerList.get(i);
//            player.setGame(game);

            List<Card> playersDeck=cardList.subList(i*5,i*5+4);
            player.setCardList(playersDeck);

            for (Card card :playersDeck) {
                card.setPlayer(player);
            }
        }
       repository.saveAll(cardList);
    }

}
