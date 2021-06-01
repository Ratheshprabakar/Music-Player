/**
 * 
 */
package com.rathesh.practice.musicplayer;

/**
 * @author Rathesh Prabakar
 *
 */
public class Song {
	String songTitle;
	double songDuration;

	public Song(String songTitle, double songDuration) {
		super();
		this.songTitle = songTitle;
		this.songDuration = songDuration;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public double getSongDuration() {
		return songDuration;
	}

	@Override
	public String toString() {
		return "Song [songTitle=" + songTitle + ", songDuration=" + songDuration + "]";
	}

}
