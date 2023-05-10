package com.moriartynho.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.dslist.dto.GameDTO;
import com.moriartynho.dslist.dto.GameMinDTO;
import com.moriartynho.dslist.entities.Game;
import com.moriartynho.dslist.projections.GameMinProjection;
import com.moriartynho.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> games = gameRepository.findAll();
		List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		GameDTO gameDTO = new GameDTO(game);
		return gameDTO;
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
