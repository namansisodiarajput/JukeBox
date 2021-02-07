package com.jukebox.application.service;

import java.util.List;

import com.jukebox.application.dto.MusicAlbumAddDto;
import com.jukebox.application.dto.MusicianAddDto;
import com.jukebox.application.models.MusicAlbums;
import com.jukebox.application.models.Musicians;

public interface JukeBoxService {

	void addOrUpdateMusician(Integer musicanId, MusicianAddDto addMusicianDto);

	void addOrUpdateMusicAlbum(Integer musicAlbumId, MusicAlbumAddDto addAlbumDto);

	List<MusicAlbums> getAllMusicAlbum();

	List<MusicAlbums> findMusicAlbumByMusician(Integer musicianId);

	List<Musicians> findMusicianByMusicAlbum(Integer musicAlbumId);
}
