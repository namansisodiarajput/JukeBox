package com.jukebox.application.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jukebox.application.dto.MusicAlbumAddDto;
import com.jukebox.application.dto.MusicAlbumResponseDto;
import com.jukebox.application.dto.MusicianAddDto;
import com.jukebox.application.models.MusicAlbums;
import com.jukebox.application.models.Musicians;
import com.jukebox.application.service.JukeBoxService;

@RestController
@RequestMapping("/jukebox")
public class JukeBoxController {
	
	@Autowired
	private JukeBoxService jukeBoxService;
	
	@PutMapping("/musician")
    public void addOrUpdateMusician(@RequestParam(name = "musicianId" , required = false) Integer musicianId, 
    								@RequestBody MusicianAddDto addMusicianDto) {
     	 
		jukeBoxService.addOrUpdateMusician(musicianId, addMusicianDto);
    }
	
	@PutMapping("/music-album")
    public void addOrUpdateMusician(@RequestParam(name = "musicAlbumId" , required = false) Integer musicAlbumId, 
    								@RequestBody MusicAlbumAddDto addMusicAlbumDto) {
     	 
		jukeBoxService.addOrUpdateMusicAlbum(musicAlbumId, addMusicAlbumDto);
    }
	
	@GetMapping("/music-album")
    public List<MusicAlbumResponseDto> getAllMusicAlbum() {
     	 
		return jukeBoxService.getAllMusicAlbum();
    }
	
	@GetMapping("/music-album/{musician-id}/musician")
    public List<MusicAlbumResponseDto> getAllMusicAlbumByMusician(@PathVariable(name = "musician-id" , required = true) Integer musicianId) {
     	 
		return jukeBoxService.findMusicAlbumByMusician(musicianId);
    }
	
	@GetMapping("/musician/{album-id}/music-album")
    public List<Musicians> getAllMusicianByMusicAlbum(@PathVariable(name = "album-id" , required = true) Integer albumId) {
     	 
		return jukeBoxService.findMusicianByMusicAlbum(albumId);
    }

}
