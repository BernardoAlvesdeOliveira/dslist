package com.devbernardo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.devbernardo.dslist.dto.GameListDTO;
import com.devbernardo.dslist.dto.GameMinDTO;
import com.devbernardo.dslist.dto.ReplacementDTO;
import com.devbernardo.dslist.services.GameListServices;
import com.devbernardo.dslist.services.GameServices;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListServices gameListServices;
	
	@Autowired
	private GameServices gameServices;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		return gameListServices.findAll();
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		return gameServices.findByList(listId);
	}

	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListServices.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
