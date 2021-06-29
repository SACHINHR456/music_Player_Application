package com.te.musicPlayer.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonPropertyOrder({"status", "message"})
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SongResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int status;

	private String message;

	@JsonProperty("Music_Files")
	@XmlElement(name = "Music-Files")
	private Songs song;

	private List<Songs> songList;

	
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Songs getSong() {
		return song;
	}

	public void setSong(Songs song) {
		this.song = song;
	}

	public List<Songs> getSongList() {
		return songList;
	}

	public void setSongList(List<Songs> songList) {
		this.songList = songList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
