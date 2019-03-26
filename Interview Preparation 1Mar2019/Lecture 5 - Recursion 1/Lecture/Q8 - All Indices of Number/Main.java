
// Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
// Do this recursively. Indexing in the array starts from 0.
// Input Format :
// Line 1 : An Integer N i.e. size of array
// Line 2 : N integers which are elements of the array, separated by spaces
// Line 3 : Integer x
// Output Format :
// indexes where x is present in the array (separated by space)
// Constraints :
// 1 <= N <= 10^3
// Sample Input :
// 5
// 9 8 10 8 8
// 8
// Sample Output :
// 1 3 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(reader.readLine());
        int[] result = allIndexes(arr, x);
        for (int v : result) {
            System.out.print(v + " ");
        }
    }

    public static int[] allIndexes(int input[], int x) {
        ArrayList<Integer> list = new ArrayList<>();
        allIndexes(input, x, 0, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    public static void allIndexes(int input[], int x, int i, ArrayList<Integer> list) {
        if (i == input.length)
            return;
        if (input[i] == x)
            list.add(i);
        allIndexes(input, x, i + 1, list);
    }
}
