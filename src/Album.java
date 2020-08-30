import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

    public String getName() {
        return name;
    }

    public void addSong (String songTitle, double duration){
        this.songList.addSong(songTitle, duration);
    }


    public boolean addToPlaylist (String songTitle, LinkedList<Song> playlist){
        Song newSong = songList.findSong(songTitle);

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

    // add a song to the playlist by its track number in the album
    public boolean addToPlaylist(int trackNo, LinkedList<Song> playlist){
        int index = trackNo-1;


        if((index >= 0) && (index < playlist.size())){
            playlist.add(this.songList.get(index));
            System.out.println("Song \"" + this.songList.get(index).getTitle() + "\" successfully added");
            return true;
        }
        System.out.println("A song with this track number not found");
        return false;
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


    private class SongList {

        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }


        private Song get(int index) {
            return this.songs.get(index);
        }


        // Add a song to the list only if it was not added before (if it is not on a list)
        private boolean addSong(String songTitle, double duration){

            if(findSong(songTitle) == null){
                songs.add(new Song(songTitle, duration));
                return true;
            } else {
                System.out.println("Song \"" + songTitle + "\" is already in the album");
                return false;
            }
        }

        // check whether the song is in the list
        // return Song if it is on a list
        // return null for validation in other methods
        private Song findSong(String songTitle){
            for(Song toBeFound : this.songs){
                if(toBeFound.getTitle().equalsIgnoreCase(songTitle)){
                    return toBeFound;
                }
            }
            return null;
        }



    }

}
