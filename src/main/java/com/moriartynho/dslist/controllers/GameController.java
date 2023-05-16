package com.moriartynho.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moriartynho.dslist.dto.GameDTO;
import com.moriartynho.dslist.dto.GameMinDTO;
import com.moriartynho.dslist.entities.Game;
import com.moriartynho.dslist.repositories.GameRepository;
import com.moriartynho.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
@CrossOrigin("*")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameRepository gameRepository;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		return gameService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	Game insert(@RequestBody Game game){
		return gameRepository.save(game);
		
	}

}
