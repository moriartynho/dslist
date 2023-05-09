package com.moriartynho.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.dslist.dto.GameMinDTO;
import com.moriartynho.dslist.entities.Game;
import com.moriartynho.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> games = gameRepository.findAll();
		List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
