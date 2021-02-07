package com.jukebox.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jukebox.application.models.MusicAlbums;

public interface MusicAlbumsRepo extends JpaRepository<MusicAlbums , Integer> {
	
	@Query(value = "SELECT * FROM music_album WHERE id = :id", nativeQuery = true)
	MusicAlbums findByMusicAlbumId(@Param("id") Integer Id);
	
	@Query(value = "SELECT * FROM music_album WHERE id IN :albumIdList ORDER BY price", nativeQuery = true)
	List<MusicAlbums> findMusicAlbumsById(@Param("albumIdList") List<Integer> albumIdList);
}
