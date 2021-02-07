package com.jukebox.application.dto;

import java.util.Date;
import java.util.List;
import com.jukebox.application.enums.MusicGenre;
import lombok.Data;

@Data
public class MusicAlbumAddDto {
	
	private String name;
	private Date dateOfRelease;
	private MusicGenre genre;
	private Double price;
	private String description;
	private List<Integer> musiciansId;
}
