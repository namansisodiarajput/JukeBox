package com.jukebox.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jukebox.application.models.Musicians;

public interface MusiciansRepo extends JpaRepository<Musicians , Integer> {
	
	@Query(value = "SELECT * FROM musicians WHERE id = :id", nativeQuery = true)
	Musicians findByMusicianId(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM musicians WHERE id IN :musicianId ORDER BY name", nativeQuery = true)
	List<Musicians> findMusicianById(@Param("musicianId") List<Integer> musicianId);
}
