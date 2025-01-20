package com.devbernardo.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devbernardo.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
