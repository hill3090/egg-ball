package com.homemade.footballgame.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homemade.footballgame.models.Player;
import com.homemade.footballgame.repository.PlayerRepository;

@RestController
@RequestMapping("/api")
public class PlayerController {
	
	private PlayerRepository playerRepository;
	
	public PlayerController(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}
	
	@GetMapping("/players")
	Collection<Player> players()	{
		return playerRepository.findAll();
	}
}
