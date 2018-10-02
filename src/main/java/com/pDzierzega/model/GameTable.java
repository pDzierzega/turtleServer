package com.pDzierzega.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
public class GameTable extends BaseEntity{

    @OneToMany
    private List<AppUser> userList;

    @OneToOne
    @JoinColumn
    private AppUser admin;

    private String name;
    private Integer numberOfPlayers;
    private boolean isStarted;
}
