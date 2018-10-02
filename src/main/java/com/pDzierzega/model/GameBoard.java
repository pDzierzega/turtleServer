package com.pDzierzega.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class GameBoard extends BaseEntity{
    @OneToOne
    private Turtle firstStage;

    @OneToOne
    private Turtle secondStage;

    @OneToOne
    private Turtle thirdStage;

    @OneToOne
    private Turtle fourthStage;

    @OneToOne
    private Turtle fifthStage;
}
