package com.devbernardo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devbernardo.dslist.dto.GameMinDTO;
import com.devbernardo.dslist.services.GameServices;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameServices gameServices;
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		return gameServices.findAll();
	}
}
