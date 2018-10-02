package com.pDzierzega.repository;

import com.pDzierzega.model.AppUser;
import com.pDzierzega.model.GameTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<GameTable,String> {
    GameTable findByUuid (String uuid);
    List<GameTable> findByUserListContaining (AppUser admin);
}
