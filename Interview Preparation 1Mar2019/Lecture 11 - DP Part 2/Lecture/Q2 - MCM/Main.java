
// Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices i.e. determine where to place parentheses to minimise the number of multiplications.
// You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.
// Input Format :
// Line 1 : Integer n i.e. number of matrices
// Line 2 : n + 1 integers i.e. elements of array p[] 
// Output Format :
// Line 1 : Minimum number of multiplication needed
// Constraints :
// 1 <= n <= 100
// Sample Input 1 :
// 3
// 10 15 20 25
// Sample Output :
// 8000
// Sample Output Explanation :
// There are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.
// If multiply in order A1*(A2*A3) then number of multiplications required are 15000.
// If multiply in order (A1*A2)*A3 then number of multiplications required are 8000.
// Thus minimum number of multiplications required are 8000

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(mcm(arr));
    }

    public static int mcm(int[] p) {
        // String arr = "n = " + (p.length - 1) + "ARR: [ ";
        // for (int v : p) arr += v + " ";
        // arr += "]";
        // int t = Integer.parseInt(arr);

        // Recursive
        // int resREC = mcmREC(p, 0, p.length - 1);
        // return resREC;

        // Memoization
        HashMap<String, Integer> map = new HashMap<>();
        int resMEM = mcmMEM(p, 0, p.length - 1, map);
        // System.out.println(map);
        return resMEM;
    }

    public static int mcmREC(int[] p, int s, int e) {
        if (s + 1 == e)
            return 0;

        ArrayList<Integer> resList = new ArrayList<>();
        int res = 0;

        for (int i = s + 1; i < e; i++) {
            int tempRes = mcmREC(p, s, i) + mcmREC(p, i, e) + p[s] * p[i] * p[e];
            resList.add(tempRes);
        }

        res = Collections.min(resList);
        return res;
    }

    public static int mcmMEM(int[] p, int s, int e, HashMap<String, Integer> map) {
        if (s + 1 == e)
            return 0;

        String str = s + "," + e;
        if (map.containsKey(str))
            return map.get(str);
        ArrayList<Integer> resList = new ArrayList<>();
        int res = 0;

        for (int i = s + 1; i < e; i++) {
            int tempRes = mcmMEM(p, s, i, map) + mcmMEM(p, i, e, map) + p[s] * p[i] * p[e];
            resList.add(tempRes);
        }

        res = Collections.min(resList);
        map.put(str, res);
        return res;
    }

}
