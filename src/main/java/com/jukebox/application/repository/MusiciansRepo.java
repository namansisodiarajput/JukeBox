package com.jukebox.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jukebox.application.models.Musicians;

public interface MusiciansRepo extends JpaRepository<Musicians , Long> {
	
	Musicians findById(Integer id);
	
	@Query(value = "SELECT * FROM musicians WHERE id IN :musicianId ORDER BY name", nativeQuery = true)
	List<Musicians> findMusicianById(List<Integer> musicianId);
}
