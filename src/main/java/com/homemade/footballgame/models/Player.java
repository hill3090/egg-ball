package com.homemade.footballgame.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="player")
public class Player {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String teamName;
	private String email;
	private String funnyFact;
}
