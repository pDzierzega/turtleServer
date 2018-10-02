package com.pDzierzega.mapper;

import com.pDzierzega.DTO.GameDTO;
import com.pDzierzega.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = PlayerMapper.class)

public interface GameMapper {
    GameDTO toGameDto (Game game);
    List<GameDTO> toGameDto (List<Game> gameList);
}
