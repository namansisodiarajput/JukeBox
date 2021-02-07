package com.jukebox.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jukebox.application.models.MusicianMappedAlbums;

public interface MusicianMappedAlbumsRepo extends JpaRepository<MusicianMappedAlbums , Integer> {
	
	@Query(value = "SELECT * FROM musicians_mapped_albums WHERE musician_id = :musicianId AND album_id = :albumId LIMIT 1", nativeQuery = true)
	MusicianMappedAlbums findByMusicianAndAlbum(@Param("musicianId") Integer musicianId, @Param("albumId") Integer albumId);
	
	@Query(value = "SELECT album_id FROM musicians_mapped_albums WHERE musician_id = :musicianId", nativeQuery = true)
	List<Integer> findAlbumByMusician(@Param("musicianId") Integer musicianId);
	
	@Query(value = "SELECT musician_id FROM musicians_mapped_albums WHERE album_id = :albumId", nativeQuery = true)
	List<Integer> findMusicianByAlbum(@Param("albumId") Integer albumId);
}
