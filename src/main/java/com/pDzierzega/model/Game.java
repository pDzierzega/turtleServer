package com.pDzierzega.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Game extends BaseEntity {

    @OneToOne
    private GameBoard gameBoard;

    @OneToMany(mappedBy = "game")
    private List<Card> deck;

    @OneToMany(mappedBy = "game")
    private List<Turtle> turtleList;

    @OneToMany(mappedBy = "game")
    private List<Player> playerList = new ArrayList<>();

}
