
// Given a positive integer n, find the minimum number of steps s, that takes n to 1. You can perform any one of the following 3 steps.
// 1.) Subtract 1 from it. (n= n - ­1) ,
// 2.) If its divisible by 2, divide by 2.( if n%2==0, then n= n/2 ) ,
// 3.) If its divisible by 3, divide by 3. (if n%3 == 0, then n = n / 3 ). 
// The time complexity of your code should be O(n).
// Input format :
// Line 1 : A single integer i.e. n
// Output format :
// Line 1 : Single integer i.e number of steps
// Constraints :
// 1 <= n <= 10^5
// Sample Input 1 :
// 4
// Sample Output 1 :
// 2 
// Sample Output 1 Explanation :
// For n = 4
// Step 1 : n = 4/2 = 2
// Step 2 : n = 2/2 = 1
// Sample Input 2 :
// 7
// Sample Output 2 :
// 3
// Sample Output 2 Explanation :
// For n = 7
// Step 1 : n = 7 ­ - 1 = 6
// Step 2 : n = 6 / 3 = 2
// Step 3 : n = 2 / 2 = 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        System.out.println(countStepsTo1(n));
    }

    public static int countStepsTo1(int n) {
        // Recursive
        // return countStepsTo1REC(n);

        // Memoized
        // HashMap<Integer, Integer> map = new HashMap<>();
        // return countStepsTo1MEM(n, map);

        // Tabulization
        return countStepsTo1TAB(n);
    }

    public static int countStepsTo1REC(int n) {
        if (n == 1)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1 + countStepsTo1REC(n - 1));
        if (n % 2 == 0)
            list.add(1 + countStepsTo1REC(n / 2));
        if (n % 3 == 0)
            list.add(1 + countStepsTo1REC(n / 3));
        return Collections.min(list);
    }

    public static int countStepsTo1MEM(int n, HashMap<Integer, Integer> map) {
        if (n == 1)
            return 0;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1 + countStepsTo1MEM(n - 1, map));
        if (n % 2 == 0)
            list.add(1 + countStepsTo1MEM(n / 2, map));
        if (n % 3 == 0)
            list.add(1 + countStepsTo1MEM(n / 3, map));
        map.put(n, Collections.min(list));
        return map.get(n);
    }

    public static int countStepsTo1TAB(int n) {
        int[] steps = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1 + steps[i - 1]);
            if (i % 2 == 0)
                list.add(1 + steps[i / 2]);
            if (i % 3 == 0)
                list.add(1 + steps[i / 3]);
            steps[i] = Collections.min(list);
        }
        return steps[n];
    }
}
