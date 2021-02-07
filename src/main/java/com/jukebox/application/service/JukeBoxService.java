package com.jukebox.application.service;

import com.jukebox.application.dto.MusicAlbumAddDto;
import com.jukebox.application.dto.MusicianAddDto;

public interface JukeBoxService {

	void addOrUpdateMusician(Integer musicanId, MusicianAddDto addMusicianDto);

	void addOrUpdateMusicAlbum(Integer musicAlbumId, MusicAlbumAddDto addAlbumDto);
}
