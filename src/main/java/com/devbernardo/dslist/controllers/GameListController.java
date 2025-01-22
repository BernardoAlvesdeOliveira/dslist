package com.devbernardo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devbernardo.dslist.dto.GameListDTO;
import com.devbernardo.dslist.dto.GameMinDTO;
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
}
