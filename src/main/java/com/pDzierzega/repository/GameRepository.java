package com.pDzierzega.repository;

import com.pDzierzega.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,String> {
}
