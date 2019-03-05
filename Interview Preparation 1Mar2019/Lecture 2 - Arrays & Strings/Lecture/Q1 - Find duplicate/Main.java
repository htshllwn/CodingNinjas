// Given an array of integers of size n which contains numbers from 0 to n - 2. 
// Each number is present at least once. 
// That is, if n = 5, numbers from 0 to 3 is present in the given array 
// at least once and one number is present twice. 
// You need to find and return that duplicate number present in the array.
// Assume, duplicate number is always present in the array.
// Input format :
// Line 1 : Size of input array
// Line 2 : Array elements (separated by space)
// Output Format :
// Duplicate element
// Constraints :
// 1 <= n <= 10^6
// Sample Input:
// 9
// 0 7 2 5 4 7 1 3 6
// Sample Output:
// 7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());

        // Reading Input Array
        String str = reader.readLine();
        String[] strArr = str.split("\\s");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        // One Line Solution for reading space separated integers as array for reference
        // int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        System.out.println(duplicate(arr));
    }

    public static int duplicate(int[] arr){
        int[] countArr = new int[arr.length];
        for(int e: arr) {
            countArr[e]++;
            if (countArr[e] > 1) return e;
        }
        return -1;
	}
}
