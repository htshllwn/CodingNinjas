
// Whis and Beerus are playing a new game today . They form a tower of N coins and make a move in alternate turns . Beerus being the God plays first . In one move player can remove 1 or X or Y coins from the tower . The person to make the last move wins the Game . Can you find out who wins the game ?
// Input Format :
// Contains three value N,X,Y as mentioned in the problem statement
// Output Format :
// A string containing the name of the winner like "Whis" or "Beeru" (without quotes)
// Constraints:
// 1<=N<=10^6
// 2<=X<=Y<=50
// Sample Input :
//  4 2 3
// Sample Output :
//  Whis

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int x = arr[1];
        int y = arr[2];
        System.out.println(solve(n, x, y));
    }

    public static String solve(int n, int x, int y) {

        // Recursive
        // return solveREC(n, x, y) ? "Beerus" : "Whis";

        // Memoization
        // HashMap<Integer, Boolean> map = new HashMap<>();
        // boolean resMEM = solveMEM(n, x, y, map);
        // System.out.println(map);
        // return resMEM ? "Beerus" : "Whis";

        // Tabulation
        boolean resTAB = solveTAB(n, x, y);
        return resTAB ? "Beerus" : "Whis";

    }

    public static boolean solveREC(int n, int x, int y) {
        if (n == 0)
            return false;
        boolean resOne = false, resTwo = false, resThree = false;
        boolean whisOne = false, whisTwo = false, whisThree = false;
        int nOne = n - 1;
        int nTwo = n - x;
        int nThree = n - y;
        if (nOne >= 0) {
            if (nOne == 0)
                return true;
            whisOne = nOne >= 1 ? solveREC(nOne - 1, x, y) : true;
            whisTwo = nOne >= x ? solveREC(nOne - x, x, y) : true;
            whisThree = nOne >= y ? solveREC(nOne - y, x, y) : true;
            resOne = (whisOne && whisTwo && whisThree);
        }
        if (nTwo >= 0) {
            if (nTwo == 0)
                return true;
            whisOne = nTwo >= 1 ? solveREC(nTwo - 1, x, y) : true;
            whisTwo = nTwo >= x ? solveREC(nTwo - x, x, y) : true;
            whisThree = nTwo >= y ? solveREC(nTwo - y, x, y) : true;
            resTwo = (whisOne && whisTwo && whisThree);
        }
        if (nThree >= 0) {
            if (nThree == 0)
                return true;
            whisOne = nThree >= 1 ? solveREC(nThree - 1, x, y) : true;
            whisTwo = nThree >= x ? solveREC(nThree - x, x, y) : true;
            whisThree = nThree >= y ? solveREC(nThree - y, x, y) : true;
            resThree = (whisOne && whisTwo && whisThree);
        }
        // System.out.println(n + ", " + resOne + ", " + resTwo + ", " + resThree);

        return resOne || resTwo || resThree;
    }

    public static boolean solveMEM(int n, int x, int y, HashMap<Integer, Boolean> map) {
        if (n == 0)
            return false;
        boolean resOne = false, resTwo = false, resThree = false;
        boolean whisOne = false, whisTwo = false, whisThree = false;
        int nOne = n - 1;
        int nTwo = n - x;
        int nThree = n - y;
        if (nOne >= 0) {
            if (nOne == 0)
                return true;
            whisOne = nOne >= 1 ? (map.containsKey(nOne - 1) ? map.get(nOne - 1) : solveMEM(nOne - 1, x, y, map))
                    : true;
            whisTwo = nOne >= x ? (map.containsKey(nOne - x) ? map.get(nOne - x) : solveMEM(nOne - x, x, y, map))
                    : true;
            whisThree = nOne >= y ? (map.containsKey(nOne - y) ? map.get(nOne - y) : solveMEM(nOne - y, x, y, map))
                    : true;
            resOne = (whisOne && whisTwo && whisThree);
        }
        if (nTwo >= 0) {
            if (nTwo == 0)
                return true;
            whisOne = nTwo >= 1 ? (map.containsKey(nTwo - 1) ? map.get(nTwo - 1) : solveMEM(nTwo - 1, x, y, map))
                    : true;
            whisTwo = nTwo >= x ? (map.containsKey(nTwo - x) ? map.get(nTwo - x) : solveMEM(nTwo - x, x, y, map))
                    : true;
            whisThree = nTwo >= y ? (map.containsKey(nTwo - y) ? map.get(nTwo - y) : solveMEM(nTwo - y, x, y, map))
                    : true;
            resTwo = (whisOne && whisTwo && whisThree);
        }
        if (nThree >= 0) {
            if (nThree == 0)
                return true;
            whisOne = nThree >= 1
                    ? (map.containsKey(nThree - 1) ? map.get(nThree - 1) : solveMEM(nThree - 1, x, y, map))
                    : true;
            whisTwo = nThree >= x
                    ? (map.containsKey(nThree - x) ? map.get(nThree - x) : solveMEM(nThree - x, x, y, map))
                    : true;
            whisThree = nThree >= y
                    ? (map.containsKey(nThree - y) ? map.get(nThree - y) : solveMEM(nThree - y, x, y, map))
                    : true;
            resThree = (whisOne && whisTwo && whisThree);
        }
        // System.out.println(n + ", " + resOne + ", " + resTwo + ", " + resThree);
        boolean res = resOne || resTwo || resThree;
        map.put(n, res);
        return res;
    }

    public static boolean solveTAB(int n, int x, int y) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        map.put(0, false);

        for (int i = 1; i <= n; i++) {
            boolean resOne = false, resTwo = false, resThree = false;
            boolean whisOne = false, whisTwo = false, whisThree = false;
            int nOne = i - 1;
            int nTwo = i - x;
            int nThree = i - y;

            if (nOne >= 0) {
                whisOne = map.containsKey(nOne - 1) ? map.get(nOne - 1) : true;
                whisTwo = map.containsKey(nOne - x) ? map.get(nOne - x) : true;
                whisThree = map.containsKey(nOne - y) ? map.get(nOne - y) : true;
                resOne = (whisOne && whisTwo && whisThree);
            }
            if (nTwo >= 0) {
                whisOne = map.containsKey(nTwo - 1) ? map.get(nTwo - 1) : true;
                whisTwo = map.containsKey(nTwo - x) ? map.get(nTwo - x) : true;
                whisThree = map.containsKey(nTwo - y) ? map.get(nTwo - y) : true;
                resTwo = (whisOne && whisTwo && whisThree);
            }
            if (nThree >= 0) {
                whisOne = map.containsKey(nThree - 1) ? map.get(nThree - 1) : true;
                whisTwo = map.containsKey(nThree - x) ? map.get(nThree - x) : true;
                whisThree = map.containsKey(nThree - y) ? map.get(nThree - y) : true;
                resThree = (whisOne && whisTwo && whisThree);
            }
            boolean res = resOne || resTwo || resThree;
            // System.out.println(i + ", " + res);
            map.put(i, res);
        }
        // System.out.println(map);
        return map.get(n);
    }
}
