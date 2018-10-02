package com.pDzierzega.repository;


import com.pDzierzega.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,String> {
}
