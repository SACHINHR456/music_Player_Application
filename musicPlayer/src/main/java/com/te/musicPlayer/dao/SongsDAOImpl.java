package com.te.musicPlayer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.musicPlayer.beans.Songs;

@Repository
public class SongsDAOImpl implements SongsDAO {

	

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public List<Songs> getAllSongs() {
		List<Songs> InfoBeans = null;

		try {
			
			EntityManager manager = factory.createEntityManager();

			Query query = manager.createQuery("from MusicInfo");

			InfoBeans = query.getResultList();
			
			
		} catch (Exception e) {
			InfoBeans = null;
			e.printStackTrace();
		}

		return InfoBeans;
	}

	@Override
	public boolean addSong(Songs musicInfo) {
		try {
			
				EntityManager manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				manager.persist(musicInfo);
				transaction.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		}
	}

	@Override
	public boolean deleteSong(int songId) {
		try {
			
				EntityManager manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
			Songs infoBean = manager.find(Songs.class, songId);
				manager.remove(infoBean);
				transaction.commit();
				return true;
			} catch (Exception e) {

				e.printStackTrace();
				return false; 

				//throw new EmployeeException("The Data is not present");
			}
	}

	@Override
	public boolean updateSong(Songs songInfo) {
		try {
			
				EntityManager manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				Songs data = manager.find(Songs.class, songInfo.getSongId());

				if (songInfo.getAlbumName() != null && songInfo.getAlbumName() != "") {
					 data .setAlbumName(songInfo.getAlbumName());
				}
				if (songInfo.getArtistName() != null && songInfo.getArtistName() != "") {
					 data .setArtistName(songInfo.getArtistName());
				}
				if (songInfo.getSongTitle() != null && songInfo.getSongTitle() != "") {
					 data .setSongTitle(songInfo.getSongTitle());
				}
				
				if (songInfo.getDescription() != null && songInfo.getDescription() != "") {
					 data .setDescription(songInfo.getDescription());
				}

				

				transaction.commit();
		return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			// TODO: handle exception
	}

	@Override
	public Songs getSongById(int songId){
	
		EntityManager manager = factory.createEntityManager();
		Songs bean = manager.find(Songs.class, songId);
		return bean;
	}

	@Override
	public Songs getSongByName(String name) {
		EntityManager manager = factory.createEntityManager();
		Songs bean = manager.find(Songs.class, name);
		return bean;
	}
}
