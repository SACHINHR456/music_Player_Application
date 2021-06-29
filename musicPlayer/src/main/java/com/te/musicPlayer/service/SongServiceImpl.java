package com.te.musicPlayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.musicPlayer.beans.Songs;
import com.te.musicPlayer.dao.SongsDAO;

@Service
public class SongServiceImpl implements SongService{


	@Autowired
	private SongsDAO dao;
	
	@Override
	public List<Songs> getAllSongs() {
		// TODO Auto-generated method stub
		return dao.getAllSongs();
	}

	@Override
	public boolean addSong(Songs songInfo) {
		// TODO Auto-generated method stub
		return dao.addSong(songInfo);
	}

	@Override
	public boolean deleteSong(int songId) {
		// TODO Auto-generated method stub
		return  dao.deleteSong(songId);
	}

	@Override
	public boolean updateSong(Songs songInfo) {
		// TODO Auto-generated method stub
		return dao.updateSong(songInfo);
	}

	@Override
	public Songs getSongById(int songId) {
		// TODO Auto-generated method stub
		return dao.getSongById(songId);
	}

	@Override
	public Songs getSongByName(String name) {
		// TODO Auto-generated method stub
		return dao.getSongByName(name);
	}
	

}
