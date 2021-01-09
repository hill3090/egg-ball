package com.homemade.footballgame.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/players/{id}")
	ResponseEntity<?> getCategory(@PathVariable Long id){
		Optional<Player> player = playerRepository.findById(id);
		 return player.map(response -> ResponseEntity.ok().body(response))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	// Insert into the category table
	@PostMapping("/player")
	ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) throws URISyntaxException	{
	  Player result= playerRepository.save(player);
	  return ResponseEntity.created(new URI("/api/player" + result.getId())).body(result); 
	
	}
}
