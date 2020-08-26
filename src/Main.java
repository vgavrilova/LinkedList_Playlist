import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static LinkedList<Album> albums = new LinkedList<Album>();
    private static LinkedList<Song> playlist = new LinkedList<Song>();

    public static void main(String[] args) {


        // create albums with some songs
        Album placeboAlbum = new Album("Battle For The Sun", "Placebo");

        placeboAlbum.addSong("Kitty Litter", 3.25);
        placeboAlbum.addSong("Ashtray Heart", 4.30);
        placeboAlbum.addSong("Battle For The Sun", 4.15);
        placeboAlbum.addSong("For What It's Worth", 4.55);
        placeboAlbum.addSong("Devil in the Details", 3.25);
        placeboAlbum.addSong("Bright Lights", 4.07);
        placeboAlbum.addSong("Speak in Tongues", 4.69);
        placeboAlbum.addSong("The Never-Ending Why", 3.59);
        placeboAlbum.addSong("Kings of Medicine", 5.00);
        albums.add(placeboAlbum);

        Album swiftAlbum = new Album("folklore", "Taylor Swift");

        swiftAlbum.addSong("the 1", 4.44);
        swiftAlbum.addSong("cardigan", 3.55);
        swiftAlbum.addSong("the last great american dynasty", 4.15);
        swiftAlbum.addSong("exile", 3.25);
        swiftAlbum.addSong("mirrorball", 4.00);
        swiftAlbum.addSong("seven", 4.44);
        swiftAlbum.addSong("august", 3.00);
        swiftAlbum.addSong("hoax", 4.5);
        albums.add(swiftAlbum);

        // add songs from the albums to the playlist
        albums.get(0).addToPlaylist("Bright Lights", playlist);
        albums.get(0).addToPlaylist("Battle For The Sun", playlist);
        albums.get(0).addToPlaylist("Kings of Medicine", playlist);
        albums.get(1).addToPlaylist("the 1", playlist);
        albums.get(1).addToPlaylist("august", playlist);
        albums.get(0).addToPlaylist("For What It's Worth", playlist);


        play(playlist);



    }

    public static void play(LinkedList<Song> playlistToBePlayed){
        printPlaylist(playlistToBePlayed);
        int choice;
        boolean quit = false;
        ListIterator<Song> playlistIterator = playlistToBePlayed.listIterator();
        // the boolean flag that checks the direction of moving
        boolean skippedForward = true;
        String currentSong;

        if(playlistToBePlayed.isEmpty()){
            System.out.println("No songs found");
        } else{
            System.out.println("Now playing \"" + playlistToBePlayed.get(0).getTitle() + "\"");
            printMenu();
        }

        while(!quit){
            System.out.println("Enter the action of your choice -- (Type 5 to see the actions)");
            choice = scan.nextInt();

            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    // if it was skipped backwards to the previous song before
                    // move the pointer
                    if(!skippedForward){
                        if(playlistIterator.hasNext()){
                            playlistIterator.next();
                            skippedForward = true;
                        }
                    }
                    if(playlistIterator.hasNext()){
                        currentSong = playlistIterator.next().getTitle();
                        System.out.println("Now playing \"" + currentSong + "\"");
                    } else {
                        System.out.println("You have reached the end of this playlist");
                        // as it is the end of the list, the pointer wasn't moved
                        // that's why the boolean flag should be set to false
                        skippedForward = false;
                    }
                    break;
                case 2:
                    // if it was skipped forward to the next song before
                    // move the pointer
                    if(skippedForward){
                        if(playlistIterator.hasPrevious()){
                            playlistIterator.previous();
                            skippedForward = false;
                        }
                    }
                    if(playlistIterator.hasPrevious()){
                        currentSong = playlistIterator.previous().getTitle();
                        System.out.println("Now playing \"" + currentSong + "\"");
                    } else {
                        System.out.println("You have reached the start of this playlist");
                        // as it is the start of the list, the pointer wasn't moved
                        // that's why the boolean flag should be set to true
                        skippedForward = true;
                    }
                    break;
                case 3:
                    // In order to play the current song multiple times
                    // I'm going to use the feature of linked lists.
                    // As the method next()/previous() returns the value that was jumped over
                    // It is checked whether the previous direction was moving forward or backwards
                    // At this time the boolean flag is set to true or false
                    // So that the same song title is showed
                    if(!skippedForward){
                        if(playlistIterator.hasNext()){
                            currentSong = playlistIterator.next().getTitle();
                            System.out.println("Playing again \"" + currentSong + "\"");
                            skippedForward = true;
                        }
                    } else if(skippedForward){
                        if(playlistIterator.hasPrevious()){
                            currentSong = playlistIterator.previous().getTitle();
                            System.out.println("Playing again \"" + currentSong + "\"");
                            skippedForward = false;
                        }
                    }
                    break;
                case 4:
                    playlistIterator.remove();
                    System.out.println("Song was removed from your playlist");
                    break;

                case 5:
                    printPlaylist(playlistToBePlayed);
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    // Print songs in a playlist
    public static void printPlaylist(LinkedList<Song> songs){
        System.out.println("Songs found in this playlist:");
        // create an iterator
        ListIterator<Song> songListIterator = songs.listIterator();

        while(songListIterator.hasNext()){
            System.out.println("- " + songListIterator.next().getTitle());
        }
        System.out.println("***********************");


    }

    public static void printMenu(){
        System.out.println("Available actions -- press ");
        System.out.println("\t 0 - To quit.");
        System.out.println("\t 1 - To play the next song");
        System.out.println("\t 2 - To play the previous song");
        System.out.println("\t 3 - To replay the current song");
        System.out.println("\t 4 - To remove the current song");
        System.out.println("\t 5 - To print songs in a playlist");
        System.out.println("\t 6 - To print available actions");
    }


}
