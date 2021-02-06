package com.homemade.footballgame.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homemade.footballgame.models.Player;
import com.homemade.footballgame.repository.PlayerRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="https://v6p9d9t4.ssl.hwcdn.net")
public class PlayerController {
	
	private PlayerRepository playerRepository;
	
	public PlayerController(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}
	
	// Get all players
	@GetMapping("/players")
	Collection<Player> players()	{
		return playerRepository.findAll();
	}
	
	// Get a specific player
	// String id
	@GetMapping("/players/{id}")
	ResponseEntity<?> getPlayer(@PathVariable String id){
		Optional<Player> player = playerRepository.findById(id);
		 return player.map(response -> ResponseEntity.ok().body(response))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	// Create new player
	@PostMapping("/player")
	ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) throws URISyntaxException	{
	  Player result= playerRepository.save(player);
	  return ResponseEntity.created(new URI("/api/player" + result.getId())).body(result); 
	
	}
	
	// Modify an existing player
	@PutMapping("player/{id}")
	ResponseEntity<Player> updatePlayer(@Valid @RequestBody Player player)	{
		Player result = playerRepository.save(player);
		return ResponseEntity.ok().body(result);

	}
	
	// Delete a player
	// String id used
	@DeleteMapping("/player/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable String id)	{
		playerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
