package com.jukebox.application.dto;

import java.util.List;
import com.jukebox.application.models.MusicAlbums;
import com.jukebox.application.models.Musicians;
import lombok.Data;

@Data
public class MusicAlbumResponseDto {
	
	private MusicAlbums musicAlbum;
	private List<Musicians> musiciansList;
	
}
