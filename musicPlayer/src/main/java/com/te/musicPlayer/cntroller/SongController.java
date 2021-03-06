package com.te.musicPlayer.cntroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.musicPlayer.beans.SongResponse;
import com.te.musicPlayer.beans.Songs;
import com.te.musicPlayer.service.SongService;

@RestController
public class SongController {

	@Autowired
	private SongService service;
	
	@GetMapping(path = "/getAllSongs", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public SongResponse getAllSongs() {
		SongResponse response = new SongResponse();
		List<Songs> infoBeans = service.getAllSongs();

		if (infoBeans != null) {
			response.setStatus(200);
			response.setMessage("success");
			response.setSongList(infoBeans);
		} else {
			response.setStatus(400);
			response.setMessage("Datas not found");
		}

		return response;
	}
	
	@PostMapping(path = "/addSongs", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public SongResponse addSongs(@RequestBody Songs musicInfo) {
		SongResponse response = new SongResponse();

		if (service.addSong(musicInfo)) {
			response.setStatus(200);
			response.setMessage("success , Added the record");
		} else {
			response.setStatus(400);
			response.setMessage("Failure , Could not add the data");
		}

		return response;
	}
	
	@DeleteMapping(path = "/deleteSongs/{iId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public SongResponse deleteSongs(@PathVariable(name = "iId")int songId ) {
		SongResponse response = new SongResponse();

		if (service.deleteSong(songId)) {
			response.setStatus(200);
			response.setMessage("success , record deleted");
		} else {
			response.setStatus(400);
			response.setMessage("Failure , Could not delete the record");
		}
		return response;
	}
	

	@PutMapping(path = "/updateSongs", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public  SongResponse updateSongs(@RequestBody Songs infoBean) {
		 SongResponse response = new  SongResponse();

		if (service.updateSong(infoBean)) {
			response.setStatus(200);
			response.setMessage("success , Updated the record");
		} else {
			response.setStatus(400);
			response.setMessage("Failure , Could not update the record");
		}
		return response;
	} // update
	

	
	@GetMapping(path="/getSongId",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public SongResponse getSongsById(int id) {
		SongResponse responce=new SongResponse();
		Songs musicInfo=service.getSongById(id);
		System.out.println(musicInfo);
		if(musicInfo != null) {
			responce.setStatus(200);
			responce.setMessage("success");
			responce.setSong(musicInfo);
		} else {
			responce.setStatus(404);
			responce.setMessage("Failure");
		}
		return responce;
	}
	

	@GetMapping(path="/getSongName",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public SongResponse getMusicByName(String name) {
		SongResponse responce=new SongResponse();
		Songs musicInfo=service.getSongByName(name);
		System.out.println(musicInfo);
		if(musicInfo != null) {
			responce.setStatus(200);
			responce.setMessage("success");
			responce.setSong(musicInfo);
		} else {
			responce.setStatus(404);
			responce.setMessage("Failure");
		}
		return responce;
	}
}
