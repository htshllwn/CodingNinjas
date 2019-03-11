// Given a random integer array, push all the zeros that are present to end of the array. The respective order of other elements should remain same.
// Change in the input array itself. You don't need to return or print elements. Don't use extra array.
// Note : You need to do this in one scan of array only.
// Input format :
// Line 1 : Integer N, Array Size
// Line 2 : Array elements (separated by space)
// Output Format :
// Array elements (separated by space)
// Constraints :
// 1 <= N <= 10^6
// Sample Input 1:
// 7
// 2 0 4 1 3 0 28
// Sample Output 1:
// 2 4 1 3 28 0 0
// Sample Input 2:
// 5
// 0 3 0 2 0
// Sample Output 2:
// 3 2 0 0 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Before ");
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println("After ");
        pushZerosAtEnd(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void pushZerosAtEnd(int[] arr){
        int noOfZeros = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                noOfZeros++;
            } else {
                arr[i - noOfZeros] = arr[i];
            }
        }
        
        for (int i = arr.length - 1; i >= arr.length - noOfZeros; i--) {
            arr[i] = 0;
        }
	}
}