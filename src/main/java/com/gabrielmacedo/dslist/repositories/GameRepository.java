package com.gabrielmacedo.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielmacedo.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
