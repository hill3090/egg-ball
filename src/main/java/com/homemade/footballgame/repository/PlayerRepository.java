package com.homemade.footballgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homemade.footballgame.models.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {
	
	Player findByName(String name);

	
}
