package com.jukebox.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jukebox.application.models.MusicAlbums;

public interface MusicAlbumsRepo extends JpaRepository<MusicAlbums , Long> {
	
	MusicAlbums findById(Integer Id);
}
