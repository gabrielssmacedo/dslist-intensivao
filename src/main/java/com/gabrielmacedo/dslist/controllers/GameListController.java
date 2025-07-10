package com.gabrielmacedo.dslist.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmacedo.dslist.dto.GameListDTO;
import com.gabrielmacedo.dslist.dto.GameMinDTO;
import com.gabrielmacedo.dslist.dto.ReplacementDTO;
import com.gabrielmacedo.dslist.services.GameListService;
import com.gabrielmacedo.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
@Tag(name = "Games List")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	@Operation(summary = "Consultar listas", description = "Permite a consulta de todas as listas de games")
	public List<GameListDTO> findAll() {
		return gameListService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Consultar lista por Id", description = "Permite a consulta de determinada lista de game pelo seu id")
	public GameListDTO findById(@PathVariable Long id) {
		return gameListService.findById(id);
	}
	
	@GetMapping(value = "/{listId}/games")
	@Operation(summary = "Consultar games da lista", description = "Permite a consulta de todos os games de uma determinada lista pelo seu id")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		return gameService.findByList(listId);
	}
	
	@PostMapping(value = "/{listId}/replacement")
	@Operation(summary = "Trocar posição do game", description = "Permite trocar a posição de um game em sua lista")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
