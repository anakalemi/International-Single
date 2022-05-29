package algorithms;

import algorithms.graph.Graph;

/**
 * @author : Ana Kalemi
 **/
public class JukeboxData {
    private int numberOfArtists;
    private int numberOfLines;

    public Graph<Integer> allArtistsGraph = new Graph<>();

    private static class LazyHolder {
        static final JukeboxData INSTANCE = new JukeboxData();
    }

    public static JukeboxData getInstance() {
        return JukeboxData.LazyHolder.INSTANCE;
    }

    public int getNumberOfArtists() {
        return numberOfArtists;
    }

    public void setNumberOfArtists(int numberOfArtists) {
        this.numberOfArtists = numberOfArtists;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

}
