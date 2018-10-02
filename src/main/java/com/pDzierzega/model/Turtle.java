package com.pDzierzega.model;

import com.pDzierzega.bootstrap.Color;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Turtle extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "game_uuid")
    private Game game;

    @NotNull
    @Enumerated
    private Color color;

    @OneToOne
    private Turtle nextTurtle;

    private Integer position;
}
