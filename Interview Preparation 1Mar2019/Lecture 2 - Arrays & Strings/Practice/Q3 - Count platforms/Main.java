
// Given two arrays (both of size n), one containing arrival time of trains and other containing the corresponding trains departure time (in the form of an integer) respectively. Return the minimum number of platform required, such that no train waits.
// Arrival and departure time of a train can't be same.
// Input Format :
// Line 1: Integer n, number of elements in arrival and departure array
// Line 2: Elements of Arrival Array (separated by spaces).
// Line 3: Elements of Departure Array (separated by spaces).
// Output Format:
// Minimum Number of Platform Needed
// Constraints :
// 1 <= n <= 100
// Sample Input 1 :
// 6
// 900 940 950 1100 1500 1800
// 910 1200 1120 1130 1900 2000
// Sample Output 1 :
// 3
// Sample Input 2 :
// 4
// 1100 1101 1103 1105
// 1110 1102 1104 1106
// Sample Output 2 :
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        int[] arrival = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] departure = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        System.out.println(platformsNeeded(arrival, departure));
    }

    public static int platformsNeeded(int arrival[], int departure[]) {
        List<Integer> scanned = new ArrayList<Integer>();
        List<Integer> platforms = new ArrayList<Integer>();
        for (int j = 0; j < arrival.length; j++) {
            int i = getEarliestTrainIndex(arrival, scanned);
            scanned.add(i);
            int index = checkPlatformAvailability(platforms, arrival[i]);
            if (index == -1) {
                // No Platform Available
                platforms.add(departure[i]);
            } else {
                platforms.set(index, departure[i]);
            }
        }
        return platforms.size();
    }

    public static int getEarliestTrainIndex(int[] arrival, List<Integer> scanned) {
        int min = -1;
        int minArrival = Integer.MAX_VALUE;
        for (int i = 0; i < arrival.length; i++) {
            if (scanned.contains(i)) {
                continue;
            }
            if (arrival[i] < minArrival) {
                minArrival = arrival[i];
                min = i;
            }
        }
        return min;
    }

    public static int checkPlatformAvailability(List<Integer> platforms, int arrival) {
        for (int i = 0; i < platforms.size(); i++) {
            if (arrival > platforms.get(i)) {
                return i;
            }
        }
        return -1;
    }

}
