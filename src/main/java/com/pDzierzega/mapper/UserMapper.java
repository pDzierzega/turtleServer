package com.pDzierzega.mapper;

import com.pDzierzega.DTO.UserDTO;
import com.pDzierzega.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {

    UserDTO toUserDto (AppUser appUser);
    List<UserDTO> toUserDto (List<AppUser> appUserList);
}
