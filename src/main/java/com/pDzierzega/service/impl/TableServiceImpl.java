package com.pDzierzega.service.impl;

import com.pDzierzega.DTO.TableDTO;
import com.pDzierzega.model.AppUser;
import com.pDzierzega.model.Game;
import com.pDzierzega.model.GameTable;
import com.pDzierzega.repository.TableRepository;
import com.pDzierzega.service.TableService;
import com.pDzierzega.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    private TableRepository repository;
    private UserService userService;

    @Autowired
    public TableServiceImpl(TableRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public List<GameTable> getAll() {
        return repository.findAll();
    }

    @Override
    public GameTable getOne(String uuid) {
        return repository.findByUuid(uuid);
    }

    @Override
    public GameTable create(Principal principal, TableDTO tableDTO) {
        GameTable gameTable =new GameTable();

        AppUser user=userService.findUser(principal);
        List<AppUser> userList=new ArrayList<>();
        userList.add(user);

        this.removePlayerOrTable(user,gameTable);

        gameTable.setAdmin(user);
        gameTable.setName(tableDTO.getName());
        gameTable.setUserList(userList);
        gameTable.setNumberOfPlayers(tableDTO.getNumberOfPlayers());
        gameTable.setStarted(false);

        return repository.save(gameTable);
    }

    @Override
    public GameTable join(Principal principal, String uuid) {
        AppUser user=userService.findUser(principal);
        GameTable gameTable = repository.findByUuid(uuid);

        this.removePlayerOrTable(user,gameTable);

        List<AppUser> userList=gameTable.getUserList();

        if (!userList.contains(user)) {
            userList.add(user);
        }
        return repository.save(gameTable);
    }


    private void removePlayerOrTable (AppUser user, GameTable gameTable){
        List<GameTable> tableList = repository.findByUserListContaining(user);
        tableList.remove(gameTable);

        for (GameTable table :tableList) {
            List<AppUser> userList= table.getUserList();
            userList.remove(user);

            if (userList.isEmpty()) {
                repository.delete(table);
            }
            else if (user.equals(table.getAdmin())){
                AppUser newAdmin=userList.get(0);
                table.setAdmin(newAdmin);
                repository.save(table);
            }
        }

    }
}
