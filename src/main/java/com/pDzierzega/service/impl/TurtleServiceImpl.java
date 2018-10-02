package com.pDzierzega.service.impl;

import com.pDzierzega.bootstrap.Color;
import com.pDzierzega.model.Turtle;
import com.pDzierzega.repository.TurtleRepository;
import com.pDzierzega.service.TurtleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurtleServiceImpl implements TurtleService {

    private TurtleRepository repository;

    @Autowired
    public TurtleServiceImpl(TurtleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Turtle> createTurtles() {
        List<Turtle> turtleList=new ArrayList<>();

        for (Color color :Color.values()) {
            Turtle turtle=new Turtle();
            turtle.setPosition(0);
            turtle.setColor(color);
            turtleList.add(turtle);
        }

        return repository.saveAll(turtleList);
    }
}
