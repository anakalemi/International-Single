package algorithms.combinatorics;

import java.util.List;

/**
 * @author : Ana Kalemi
 **/
public class Formula {

    public static int getNumberOfCombinations(int t, int n, List<Integer> A) {
        int combinations = 0;
        for (int i = 0; i < n; i++) {
            combinations += A.get(i) * (t - A.get(i));
        }
        return combinations / 2;
    }
}
