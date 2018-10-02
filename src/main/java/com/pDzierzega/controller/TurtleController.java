package com.pDzierzega.controller;

import com.pDzierzega.DTO.TurtleDTO;
import com.pDzierzega.bootstrap.Color;
import com.pDzierzega.model.Game;
import com.pDzierzega.model.Turtle;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/turtle")
@CrossOrigin(origins = "http://localhost:4200")
public class TurtleController {

    @GetMapping
    public TurtleDTO getMoced (){
        TurtleDTO blueTurtle=new TurtleDTO();

        blueTurtle.setColor(Color.BLUE);
        blueTurtle.setPosition(0);
        blueTurtle.setUuid("00");

        TurtleDTO redTurtle=new TurtleDTO();

        redTurtle.setColor(Color.RED);
        redTurtle.setPosition(0);
        redTurtle.setUuid("11");
        redTurtle.setNextTurtle(blueTurtle);

        return redTurtle;
    }
}
