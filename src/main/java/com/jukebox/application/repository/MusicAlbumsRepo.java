package com.jukebox.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jukebox.application.models.MusicAlbums;

public interface MusicAlbumsRepo extends JpaRepository<MusicAlbums , Long> {
	
	MusicAlbums findById(Integer Id);
	
	@Query(value = "SELECT * FROM music_album WHERE id IN :albumIdList ORDER BY price", nativeQuery = true)
	List<MusicAlbums> findMusicAlbumsById(List<Integer> albumIdList);
}
