package com.jukebox.application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jukebox.application.dto.MusicAlbumAddDto;
import com.jukebox.application.dto.MusicianAddDto;
import com.jukebox.application.exceptions.BadRequestException;
import com.jukebox.application.models.MusicAlbums;
import com.jukebox.application.models.MusicianMappedAlbums;
import com.jukebox.application.models.Musicians;
import com.jukebox.application.repository.MusicAlbumsRepo;
import com.jukebox.application.repository.MusicianMappedAlbumsRepo;
import com.jukebox.application.repository.MusiciansRepo;
import com.jukebox.application.service.JukeBoxService;

@Service
public class JukeBoxServiceImpl implements JukeBoxService {
	
	@Autowired
	private MusiciansRepo musiciansRepo;
	
	@Autowired
	private MusicAlbumsRepo musicAlbumRepo;
	
	@Autowired
	private MusicianMappedAlbumsRepo musicianMappedAlbumRepo;
	
	@Override 
	public void addOrUpdateMusician(Integer musicianId, MusicianAddDto addMusicianDto) {
		
		Musicians musician = null;
		//create or update musician
		if(musicianId != null) {
			
			musician = musiciansRepo.findById(musicianId);
			if(musician == null) {
				throw new BadRequestException("Musican Id is Wrong");
			}
			
		} else {
			musician = new Musicians();
			musician.setName(addMusicianDto.getName());
		}	
	
		musician.setMusicianType(addMusicianDto.getMusicianType());
		musiciansRepo.save(musician);
	}
	
	
	@Override 
	public void addOrUpdateMusicAlbum(Integer musicAlbumId, MusicAlbumAddDto addAlbumDto) {
		
		//add or update music album
		MusicAlbums musicAlbum = new MusicAlbums();
		if(musicAlbumId != null) {
			musicAlbum = musicAlbumRepo.findById(musicAlbumId);
			if(musicAlbum == null) {
				throw new BadRequestException("Music Albums Id is Wrong");
			}
		} else {
			musicAlbum.setName(addAlbumDto.getName());
		}
		
		musicAlbum.setDateOfRelease(addAlbumDto.getDateOfRelease());
		musicAlbum.setGenre(addAlbumDto.getGenre());
		musicAlbum.setPrice(addAlbumDto.getPrice());
		musicAlbum.setDescription(addAlbumDto.getDescription());
		
		musicAlbum = musicAlbumRepo.save(musicAlbum);
		
		//add all musicans to album
		addMusicianToAlbum(musicAlbum.getId(), addAlbumDto.getMusiciansId());
	}
	
	// save all the List of musicians associated to single album
	private void addMusicianToAlbum(Long albumId, List<Integer> musicianIdList) {
			
		MusicAlbums musicAlbum = musicAlbumRepo.findById(albumId.intValue());
		if(musicAlbum == null) {
			throw new BadRequestException("Music Albums Id is Wrong");
		}
		
		for(Integer musicianId: musicianIdList) {
			
			Musicians musician = musiciansRepo.findById(musicianId);
			if(musician == null) {
				throw new BadRequestException("Musican Id is Wrong");
			}
			
			MusicianMappedAlbums musicianMappedAlbum = new MusicianMappedAlbums();
			musicianMappedAlbum.setMusician(musician);
			musicianMappedAlbum.setAlbum(musicAlbum);
			musicianMappedAlbumRepo.save(musicianMappedAlbum);
		}
		
	}

}
