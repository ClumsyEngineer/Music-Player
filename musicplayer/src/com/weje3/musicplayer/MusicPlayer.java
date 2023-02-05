package com.weje3.musicplayer;

import java.util.*;

public class MusicPlayer {
	
	private static ArrayList<Album> albums = new ArrayList<>();
	public static void main(String[]args) {
				
		Album album=new Album("Way Ahead","Karan Aujla");
		album.addSong("Game Over", 2.34);
		album.addSong("Gangsta", 3.10);
		album.addSong("They Know", 2.24);
		album.addSong("Unreachable", 3.57);
		album.addSong("Oouuu", 2.27); 
		albums.add(album); 
		
		album = new Album("MoonChild Era", "Diljit Dosanjh");
		album.addSong("Vibe", 2.36);
		album.addSong("Hoops", 3.11);
		album.addSong("Cali", 2.45);
		album.addSong("Da Crew", 2.58);
		album.addSong("Black & White", 3.15);
		albums.add(album);
		
		album = new Album("Moosetape", "Sidhu Moose Wala");
		album.addSong("IDGAF", 2.57);
		album.addSong("Racks and Rounds", 3.46);
		album.addSong("Moosedrilla", 3.53);
		album.addSong("Celebrity Killer", 3.24);
		album.addSong("Malwa Block", 3.15);
		albums.add(album);
		
		LinkedList<Song> songList = new LinkedList<>();
		
		albums.get(0).addToPlayList("Game Over", songList);
		albums.get(0).addToPlayList("Gangsta", songList);
		albums.get(0).addToPlayList("They Know", songList);
		albums.get(0).addToPlayList("Unreachable", songList);
		albums.get(0).addToPlayList("Oouuu", songList);
		
		albums.get(1).addToPlayList("Vibe", songList);
		albums.get(1).addToPlayList("Hoops", songList);
		albums.get(1).addToPlayList("Cali", songList);
		albums.get(1).addToPlayList("Da Crew", songList);
		albums.get(1).addToPlayList("Black & White", songList);
		
		albums.get(2).addToPlayList("IDGAF", songList);
		albums.get(2).addToPlayList("Racks and Rounds", songList);
		albums.get(2).addToPlayList("Moosedrilla", songList);
		albums.get(2).addToPlayList("Celebrity Killer", songList);
		albums.get(2).addToPlayList("Malwa Block", songList);
		
		play(songList);
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		boolean backward = true;
		ListIterator<Song> listIterator = playList.listIterator();

		if (playList.size() == 0) {
			System.out.println("PlayList is Empty");
		} else {
			System.out.println();
			System.out.println("Now playing : " + listIterator.next().toString());
			System.out.println();
			printMenu();
		}

		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();

			switch (action) {

			case 1:
				while (backward) {
					printList(playList);

					System.out.println("1. Play song by entering a number \n" + "2. Back()");

					action = sc.nextInt();
					switch (action) {
					case 1: {
						System.out.println("Enter a song number");
						action = sc.nextInt();
						Iterator<Song> iterator = playList.iterator();
						int num = 0;
						while (iterator.hasNext()) {
							num++;
							if (action == num) {
								System.out.println(iterator.next());
							}
							iterator.next();
						}
						
						System.out.println();
						break;
					}
					case 2: {
						printMenu();
						backward = false;
						break;
					}
					}
				}
				break;

			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Now playing " + listIterator.previous().toString());
				} else {
					System.out.println("This is first song");
					forward = false;
				}
				break;

			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = false;
					} else {
						System.out.println("we are at the start of the list");
					}
				} else {
					if (listIterator.hasNext()) {
						System.out.println("now playing " + listIterator.next().toString());
						forward = true;
					} else {
						System.out.println("we have reached to the end of list");
					}
				}
				break;

			case 4:
				if (!forward) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now playing " + listIterator.next().toString());
				} else {
					System.out.println("no song availble, reached to the end of the list");
					forward = false;
				}
				break;

			case 5:
				if (playList.size() > 0) {
					listIterator.remove();
					if (listIterator.hasNext()) {
						System.out.println("now playing " + listIterator.next().toString());
					} else {
						if (listIterator.hasPrevious())
							System.out.println("now playing " + listIterator.previous().toString());
					}
				}
				break;

			case 6:
				System.out.println("Thank you!!");
				quit = true;
				break;

			}
		}
	}

	private static void printMenu() {
		System.out.println(" <********** MENU **********");
		System.out.println("1 - Songs List\n" +
						"2 - Previous Song \n" +
						"3 - Restart\n" +
						"4 - Play Next Song \n"+
						"5 - Delete Current Song\n" +
						"6 - Stop()\n");
	}

	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println();
		int num = 1;
		while (iterator.hasNext()) {
			System.out.print(num++ + " ");
			System.out.println(iterator.next());
		}

		System.out.println();
	}

	
}

