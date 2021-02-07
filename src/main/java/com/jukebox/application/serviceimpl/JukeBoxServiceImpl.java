package com.jukebox.application.serviceimpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jukebox.application.constants.ErrorMessages;
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
			
			musician = musiciansRepo.findByMusicianId(musicianId);
			if(musician == null) {
				throw new BadRequestException(ErrorMessages.MUSICIAN_ID_INVALID);
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
			musicAlbum = musicAlbumRepo.findByMusicAlbumId(musicAlbumId);
			if(musicAlbum == null) {
				throw new BadRequestException(ErrorMessages.MUSIC_ALBUM_ID_INVALID);
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
		if(addAlbumDto.getMusiciansId() != null && addAlbumDto.getMusiciansId().size() > 0) {
			addMusicianToAlbum(musicAlbum.getId(), addAlbumDto.getMusiciansId());
		}
	}
	
	@Override 
	public List<MusicAlbums> getAllMusicAlbum() {
		
		List<MusicAlbums> musicAlbumList = musicAlbumRepo.findAll();
		
		//Sort by Date of Release 
        Comparator<MusicAlbums> compareByDateRelease = (MusicAlbums album1, MusicAlbums album2) -> 
        album1.getDateOfRelease().compareTo(album2.getDateOfRelease());  
        Collections.sort(musicAlbumList,  compareByDateRelease);
        
        return musicAlbumList;
	}
	
	@Override 
	public List<MusicAlbums> findMusicAlbumByMusician(Integer musicianId) {
		
		List<Integer> musicAlbumIdList = musicianMappedAlbumRepo.findAlbumByMusician(musicianId);
		
		// Find all music album, Sort by Price
		return musicAlbumRepo.findMusicAlbumsById(musicAlbumIdList);
   	}
	
	@Override 
	public List<Musicians> findMusicianByMusicAlbum(Integer musicAlbumId) {
		
		List<Integer> muscianIdList = musicianMappedAlbumRepo.findMusicianByAlbum(musicAlbumId);
		
		// Find all Musician, Sort by Musician Name
		return musiciansRepo.findMusicianById(muscianIdList);
   	}
	
	// save all the List of musicians associated to single album
	private void addMusicianToAlbum(Integer albumId, List<Integer> musicianIdList) {
			
		MusicAlbums musicAlbum = musicAlbumRepo.findByMusicAlbumId(albumId);
		if(musicAlbum == null) {
			throw new BadRequestException(ErrorMessages.MUSIC_ALBUM_ID_INVALID);
		}
		
		for(Integer musicianId: musicianIdList) {
			
			Musicians musician = musiciansRepo.findByMusicianId(musicianId);
			if(musician == null) {
				throw new BadRequestException(ErrorMessages.MUSICIAN_ID_INVALID);
			}
						
			//if mapping already exist dont add
			MusicianMappedAlbums musicianMappedAlbum = musicianMappedAlbumRepo.findByMusicianAndAlbum(musician.getId(), musicAlbum.getId());
			
			if(musicianMappedAlbum == null) {
				musicianMappedAlbum = new MusicianMappedAlbums();
				musicianMappedAlbum.setMusician(musician);
				musicianMappedAlbum.setAlbum(musicAlbum);
				musicianMappedAlbumRepo.save(musicianMappedAlbum);
			}
		}
		
	}

}
