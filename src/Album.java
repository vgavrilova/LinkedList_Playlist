import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }


    // Add a song to the album only if it was not added before (if it is not on a list)
    public boolean addSong(String songTitle, double duration){

        if(findSong(songTitle) == null){
            songs.add(new Song(songTitle, duration));
            return true;
        } else {
            System.out.println("Song \"" + songTitle + "\" is already in the album");
            return false;
        }
    }


    // check whether the song is in the album
    // return Song if it is on a list
    // return null for validation in other methods
    private Song findSong(String songTitle){
        for(Song toBeFound : songs){
            if(toBeFound.getTitle().equalsIgnoreCase(songTitle)){
                return toBeFound;
            }
        }
        return null;
    }

    public boolean addToPlaylist (String songTitle, LinkedList<Song> playlist){
        Song newSong = findSong(songTitle);

        // add a song to the playlist if it is in the album
        // and if this song is not on a playlist
        if((newSong != null) && !(inPlaylist(playlist, songTitle))){
            playlist.add(newSong);
            System.out.println("Song \"" + newSong.getTitle() + "\" successfully added");
            return true;
        } else {
            System.out.println("Song \"" + newSong.getTitle() + "\" could not be added to this playlist");
            return false;
        }

    }

    // check whether a particular song already exists on a playlist
    private boolean inPlaylist (LinkedList<Song> playlist, String songTitle){
        for(Song isInPlaylist : playlist){
            if(isInPlaylist.getTitle().equalsIgnoreCase(songTitle)){
                return true;
            }
        }
        return false;
    }


}
