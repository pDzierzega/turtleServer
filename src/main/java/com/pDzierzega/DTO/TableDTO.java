package com.pDzierzega.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TableDTO {
    private String uuid;
    private String name;
    private Integer numberOfPlayers;
    private List<UserDTO> userList;
}
