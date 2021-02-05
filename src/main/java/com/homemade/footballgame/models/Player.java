package com.homemade.footballgame.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate(true)
@Data
@Table(name="player")
public class Player {
	
	@Id
	private String id;

	private String name;
	private String teamName;
	private String email;
	private String funnyFact;
	private int score;
	// New Column added
	private int secret;
}
