package com.jukebox.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jukebox.application.dto.MusicianAddDto;
import com.jukebox.application.models.Musicians;
import com.jukebox.application.repository.MusiciansRepo;
import com.jukebox.application.service.JukeBoxService;

@Service
public class JukeBoxServiceImpl implements JukeBoxService {
	
	@Autowired
	private MusiciansRepo musiciansRepo;
	
	@Override 
	public void addMusician(MusicianAddDto addMusicianDto) {
			
		Musicians newMusician = new Musicians();
		newMusician.setName(addMusicianDto.getName());
		newMusician.setMusicianType(addMusicianDto.getMusicianType());
		musiciansRepo.save(newMusician);
	}

}
