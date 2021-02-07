package com.jukebox.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jukebox.application.models.Musicians;

public interface MusiciansRepo extends JpaRepository<Musicians , Integer> {

}
