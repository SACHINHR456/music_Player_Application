package com.te.musicPlayer.service;

import java.util.List;

import com.te.musicPlayer.beans.Songs;

public interface SongService {

public List<Songs> getAllSongs();
	
	public boolean addSong(Songs songInfo);
	
	public boolean deleteSong(int songId);
	
	
	public boolean updateSong(Songs songInfo);
	
	public Songs getSongById(int songId);

	public Songs getSongByName(String name);
}
