package com.jukebox.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.jukebox.application.enums.MusicianType;

import lombok.Data;

@Data
@Entity(name = "musicians")
public class Musicians {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "musician_type")
	private MusicianType musicianType;
}
