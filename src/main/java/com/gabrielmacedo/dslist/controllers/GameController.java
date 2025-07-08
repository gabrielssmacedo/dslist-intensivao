package com.gabrielmacedo.dslist.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielmacedo.dslist.dto.GameDTO;
import com.gabrielmacedo.dslist.dto.GameMinDTO;
import com.gabrielmacedo.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
@Tag(name = "Games", description = "Gerenciador de games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	@Operation(summary = "Consultar games", description = "Permite a consulta de todos os games cadastrados")
	public List<GameMinDTO> findAll() {
		return gameService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Consultar games por Id", description = "Permite a consulta de um game cadastrado pelo seu id")
	public GameDTO findById(@PathVariable Long id) {
		return gameService.findById(id);
	}
}
