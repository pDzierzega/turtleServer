package com.pDzierzega.DTO;

import com.pDzierzega.model.Player;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class GameDTO {
    private String uuid;
    private List<Player> playerList;
    private Player scoffer;
}
