package org.lld.prep.playlist_shuffle;

import java.util.*;

interface PlaylistIterator {
    boolean hasNext();
    String next();
}

class ShufflePlaylist implements PlaylistIterator {

    private List<String> songs;
    private int currIndx;
    private List<String> shuffleSongs;
    private Random random;

    public ShufflePlaylist(List<String> songs) {
        this.songs = songs;
        shuffleSongs = new ArrayList<>(songs);
        random = new Random();
    }

    private void reshuffle() {
        shuffleSongs = new ArrayList<>(songs);
        Collections.shuffle(shuffleSongs,random);
        currIndx = 0;
    }

    public String currentSong() {
        if(currIndx >= songs.size()) {
            reshuffle();
        }

        return shuffleSongs.get(currIndx);
    }

    @Override
    public boolean hasNext() {
        return !this.songs.isEmpty();
    }

    @Override
    public String next() {
        if(currIndx >= songs.size()) {
            reshuffle();
        }
        return shuffleSongs.get(++currIndx);
    }
}

public class MainClass {
    public static void main(String[] args) {
        List<String> songs = new ArrayList<>(Arrays.asList("Chor Bazar","Meri Aakhen","Tere Chaubare","Maru Tujhe"));

        ShufflePlaylist shufflePlaylist = new ShufflePlaylist(songs);

        for(int i=0;i<3;i++) {
            System.out.println("Current Playing:"+ shufflePlaylist.currentSong());
            shufflePlaylist.next();
        }
    }
}
