package com.moriartynho.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
