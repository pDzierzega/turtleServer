package com.pDzierzega.DTO;

import com.pDzierzega.bootstrap.Color;
import com.pDzierzega.model.Game;
import com.pDzierzega.model.Turtle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurtleDTO {
    private String uuid;
    private Color color;
    private TurtleDTO nextTurtle;
    private Integer position;
}
