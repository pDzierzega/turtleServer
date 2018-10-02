package com.pDzierzega.model;


import com.pDzierzega.bootstrap.Color;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Card extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "game_uuid")
    private Game game;

    @NotNull
    @Enumerated
    private Color color;

    @NonNull
    private int move;

    @NotNull
    private boolean isUsed;

    @OneToOne
    private Player player;
}
