package com.pDzierzega.model;

import com.pDzierzega.bootstrap.Color;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Player extends BaseEntity {

    @NotNull
    @Enumerated
    private Color color;

    @ManyToMany
    @JoinTable( name = "player_card",
            joinColumns = @JoinColumn(name = "player_uuid"),
            inverseJoinColumns = @JoinColumn(name = "card_uuid"))
    private List<Card> cardList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_uuid")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appUser_uuid")
    private AppUser user;

}
