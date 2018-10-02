package com.pDzierzega.repository;

import com.pDzierzega.model.AppUser;
import com.pDzierzega.model.GameBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameBoardRepository extends JpaRepository<GameBoard,String> {
}
