package com.pDzierzega.mapper;

import com.pDzierzega.DTO.TableDTO;
import com.pDzierzega.model.GameTable;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = UserMapper.class)

public interface TableMapper {
    TableDTO toTableDTO(GameTable gameTable);
    List<TableDTO> toTableDTO(List<GameTable> gameTableList);
}
