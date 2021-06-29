package com.te.musicPlayer.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "MusicFiles")
@XmlRootElement(name="Music-Files")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("Music_Files")
public class Songs {

	@Id
	@Column(name = "Song_ID")
	private int songId;

	@Column(name = "Song_Title")
	private String songTitle;

	@Column(name = "Artist_Name")
	private String artistName;

	@Column(name = "Album_Name")
	private String albumName;

	@Column(name = "Song_Location")
	private String songLocation;

	@Column(name = "Description")
	private String description;

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getSongLocation() {
		return songLocation;
	}

	public void setSongLocation(String songLocation) {
		this.songLocation = songLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
