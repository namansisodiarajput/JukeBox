package com.jukebox.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jukebox.application.models.MusicianMappedAlbums;

public interface MusicianMappedAlbumsRepo extends JpaRepository<MusicianMappedAlbums , Integer> {

}
