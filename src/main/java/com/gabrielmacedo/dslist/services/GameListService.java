package com.gabrielmacedo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielmacedo.dslist.dto.GameListDTO;

import com.gabrielmacedo.dslist.entities.GameList;
import com.gabrielmacedo.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id){
		GameList result = gameListRepository.findById(id).get();
		return new GameListDTO(result);
	}
}
