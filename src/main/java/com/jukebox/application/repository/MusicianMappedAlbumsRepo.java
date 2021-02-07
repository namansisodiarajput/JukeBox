package com.jukebox.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jukebox.application.models.MusicianMappedAlbums;

public interface MusicianMappedAlbumsRepo extends JpaRepository<MusicianMappedAlbums , Integer> {
	
	@Query(value = "SELECT album_id FROM musician_mapped_albums WHERE musician_id = :musicianId", nativeQuery = true)
	List<Integer> findAlbumByMusician(Integer musicianId);
	
	@Query(value = "SELECT musician_id FROM musician_mapped_albums WHERE album_id = :albumId", nativeQuery = true)
	List<Integer> findMusicianByAlbum(Integer albumId);
}
