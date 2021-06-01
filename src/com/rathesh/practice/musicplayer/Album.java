/**
 * 
 */
package com.rathesh.practice.musicplayer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Admin
 *
 */
public class Album {
	private String albumName;
	private String albumArtist;
	private ArrayList<Song> songs;

	public Album(String albumName, String albumArtist) {
		super();
		this.albumName = albumName;
		this.albumArtist = albumArtist;
		this.songs = new ArrayList<Song>();
	}

	public Song findSongInAlbum(String title) {

		for (Song checkSong : songs) {
			if (checkSong.getSongTitle().equals(title)) {
				return checkSong;
			}
		}
		return null;
	}

	public boolean addSongToAlbum(Song s) {
		if (findSongInAlbum(s.getSongTitle()) == null) {
			songs.add(new Song(s.songTitle, s.songDuration));
			// System.out.println("Song Successfully added");
			return true;
		} else {
			// System.out.println("Song with this " + s.getSongTitle() + " already existed
			// in this album");
			return false;
		}
	}

	public boolean addSongToPlayList(int trackNumber, LinkedList<Song> playList) {
		int index = trackNumber - 1;
		if (index > 0 && index <= this.songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
		// System.out.println("This album doesn't have song with track number "+
		// trackNumber);
		return false;
	}

	public boolean addSongToPlayList(String title, LinkedList<Song> playList) {

		if (findSongInAlbum(title) != null) {
			Song checkedSong = findSongInAlbum(title);
			playList.add(checkedSong);
			return true;
		}
		// System.out.println("This album doesn't have song with this title "+ title);
		return false;
	}

}
