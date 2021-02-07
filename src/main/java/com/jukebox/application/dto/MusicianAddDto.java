package com.jukebox.application.dto;

import com.jukebox.application.enums.MusicianType;
import lombok.Data;

@Data
public class MusicianAddDto {
	
	private String name;
	private MusicianType musicianType;
}
