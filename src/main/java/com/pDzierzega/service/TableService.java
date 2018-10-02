package com.pDzierzega.service;


import com.pDzierzega.DTO.TableDTO;
import com.pDzierzega.model.GameTable;

import java.security.Principal;
import java.util.List;

public interface TableService {
    List<GameTable> getAll();
    GameTable getOne(String uuid);

    GameTable create(Principal principal, TableDTO table);
    GameTable join(Principal principal, String uuid);

}
