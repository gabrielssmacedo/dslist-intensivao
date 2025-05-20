package com.gabrielmacedo.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielmacedo.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
