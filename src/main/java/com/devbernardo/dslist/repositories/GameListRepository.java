package com.devbernardo.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devbernardo.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
