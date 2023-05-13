package com.moriartynho.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.dslist.dto.GameListDTO;
import com.moriartynho.dslist.entities.GameList;
import com.moriartynho.dslist.projections.GameMinProjection;
import com.moriartynho.dslist.repositories.GameListRepository;
import com.moriartynho.dslist.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	public List<GameListDTO> findAll() {
		List<GameList> games = gameListRepository.findAll();
		return games.stream().map(x -> new GameListDTO(x)).toList();

	}

	@org.springframework.transaction.annotation.Transactional
	public void move(Long listId, int sourceIndex, int destinatioIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinatioIndex, obj);

		int min = sourceIndex < destinatioIndex ? sourceIndex : destinatioIndex;
		int max = sourceIndex > destinatioIndex ? destinatioIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}

	}

}
