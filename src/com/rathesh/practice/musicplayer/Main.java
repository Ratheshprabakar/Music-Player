/**
 * 
 */
package com.rathesh.practice.musicplayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author Rathesh Prabakar
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Album> albumList = new ArrayList<Album>();
		LinkedList<Song> playList1 = new LinkedList<Song>();

		Album album = new Album("Rap", "Rathesh");

		album.addSongToAlbum(new Song("TNT", 4.5));
		album.addSongToAlbum(new Song("Highway to Hell", 3.5));
		album.addSongToAlbum(new Song("ThunderStruct", 5.0));
		album.addSongToAlbum(new Song("Enjami", 3.2));

		Album album2 = new Album("Melody", "Eminem");

		album2.addSongToAlbum(new Song("Rap God", 4.5));
		album2.addSongToAlbum(new Song("Not Afraid", 3.5));
		album2.addSongToAlbum(new Song("Lose Yourself", 3.2));

		albumList.add(album);
		albumList.add(album2);

		albumList.get(0).addSongToPlayList("TNT", playList1);
		albumList.get(0).addSongToPlayList("Highway to Hell", playList1);
		albumList.get(0).addSongToPlayList("Enjami", playList1);
		albumList.get(1).addSongToPlayList("Not Afraid", playList1);
		albumList.get(1).addSongToPlayList("Love Yourself", playList1);

		play(playList1);

	}

	public static void play(LinkedList<Song> pl) {

		Scanner input = new Scanner(System.in);
		System.out.println("\nWelcome to MX Player\n");
		ListIterator<Song> itr = pl.listIterator();

		if (pl.size() == 0)
			System.out.println("This playlist have no songs");
		else {
			System.out.println("Now Playing: " + itr.next().getSongTitle());
		}

		int choice = 99;
		while(choice!=0) {
			
			printMenu();
			choice = input.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Playlist Stopped");
				break;
			
			case 1:
				if (itr.hasNext())
					System.out.println("Now Playing: " + itr.next().getSongTitle());
				else
					System.out.println("No next song is available, it is the last song in playlist");
				break;
	
			case 2:
				if (itr.hasPrevious())
					System.out.println("Now Playing: " + itr.previous().getSongTitle());
				else
					System.out.println("This is your first song in the playlist, no previous available");
				break;
			case 4:
				printList(pl);
				break;
			case 5:
				itr.remove();
				if (itr.hasNext())
					System.out.println("Now Playing " + itr.next().getSongTitle());
				else
					System.out.println("Now Playing " + itr.previous().getSongTitle());
				break;
			}
		}
		input.close();
	}

	private static void printMenu() {
		System.out.println("\nAvailable Options, Press\n");
		System.out.println("1- To Play Next Song\n" +
				"2 - To Play Previous Song\n" + 
				"3 - To Replay the current song\n" +
				"4 - List all songs in the current playlist\n" +
				"5 - Delete current song from playlist\n"+ 
				"0 - Quit");
	}

	public static void printList(LinkedList<Song> playList) {
		System.out.println("---Welcome to MX Player----");
		for (Song song : playList) {
			System.out.println(song.getSongTitle());
		}
	}

}
