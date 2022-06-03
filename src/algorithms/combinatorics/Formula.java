package algorithms.combinatorics;

import java.util.List;

/**
 * @author : Ana Kalemi
 **/
public class Formula {

    /**
     * Returns the number of all possible distinct pair combinations where
     * the pair entities are to be selected from n - groups of entities.
     * @custom.precondition Each entity belongs to one group only.
     * @custom.postcondition The resulting pair combinations have entities of different groups.
     *
     * @param t number of total entities
     * @param n number of groups of entities
     * @param A list of number of entities of each group
     * @return the number of combinations
     */
    public static int getNumberOfCombinations(int t, int n, List<Integer> A) {
        int combinations = 0;
        for (int i = 0; i < n; i++) {
            combinations += A.get(i) * (t - A.get(i));
        }
        return combinations / 2;
    }
}
