package com.pDzierzega.controller;

import com.pDzierzega.DTO.TableDTO;
import com.pDzierzega.mapper.TableMapper;
import com.pDzierzega.model.GameTable;
import com.pDzierzega.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/table")
@CrossOrigin(origins = "http://localhost:4200")
public class TableController {

    private TableService service;
    private TableMapper mapper;

    @Autowired
    public TableController(TableService service, TableMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TableDTO> getAll(){
        List<GameTable> builderList=service.getAll();
        return mapper.toTableDTO(builderList);
    }

    @GetMapping("/{uuid}")
    public TableDTO getOne(@PathVariable String uuid){
        GameTable builder=service.getOne(uuid);
        return mapper.toTableDTO(builder);
    }

    @PostMapping("/{uuid}")
    public TableDTO joinGame(@PathVariable String uuid, Principal principal){
        GameTable builder=service.join(principal,uuid);
        return mapper.toTableDTO(builder);
    }

    @PostMapping("/new")
    public TableDTO createTable(@RequestBody TableDTO table, Principal principal){
        GameTable builder=service.create(principal,table);
        return mapper.toTableDTO(builder);
    }

    @PostMapping("/join/{uuid}")
    public TableDTO joinTable(@PathVariable String uuid, Principal principal){
        GameTable builder=service.join(principal,uuid);
        return mapper.toTableDTO(builder);
    }

}
