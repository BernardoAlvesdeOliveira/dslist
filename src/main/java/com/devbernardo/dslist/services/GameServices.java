package com.devbernardo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devbernardo.dslist.dto.GameMinDTO;
import com.devbernardo.dslist.entities.Game;
import com.devbernardo.dslist.repositories.GameRepository;

@Service
public class GameServices {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
