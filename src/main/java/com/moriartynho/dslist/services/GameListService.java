package com.moriartynho.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.dslist.dto.GameListDTO;
import com.moriartynho.dslist.entities.GameList;
import com.moriartynho.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	public List<GameListDTO> findAll() {
		List<GameList> games = gameListRepository.findAll();
		return games.stream().map(x -> new GameListDTO(x)).toList();

	}

}
