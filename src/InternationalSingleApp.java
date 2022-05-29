import algorithms.JukeboxData;
import algorithms.combinatorics.Formula;
import algorithms.utils.FileReaderUtils;

import java.util.*;

/**
 * @author : Ana Kalemi
 **/
public class InternationalSingleApp {

    public static void main(String[] args) {

        new FileReaderUtils();

        Map<Integer, Integer> stronglyConnectedComponents = JukeboxData.getInstance()
                .allArtistsGraph.getStronglyConnectedComponents();

        Map<Integer, Integer> map = new HashMap<>();
        stronglyConnectedComponents.forEach((elem, scc) ->
                map.put(scc, map.containsKey(scc) ? map.get(scc) + 1 : 1));

        int numberOfCombinations = Formula.getNumberOfCombinations(
                JukeboxData.getInstance().getNumberOfArtists(),
                map.keySet().size(),
                map.values().stream().toList()
        );

        System.out.println("Given " + JukeboxData.getInstance().getNumberOfArtists() + " artists.");
        System.out.println("Number of pair combinations having different nationalities: " + numberOfCombinations);
    }
}
