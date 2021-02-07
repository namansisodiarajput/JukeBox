package com.jukebox.application.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.jukebox.application.enums.MusicGenre;
import lombok.Data;

@Data
@Entity(name = "music_album")
public class MusicAlbums {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_of_release")
	private Date dateOfRelease;
	
	@Column(name = "genre")
	private MusicGenre genre;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "description")
	private String description;
}
