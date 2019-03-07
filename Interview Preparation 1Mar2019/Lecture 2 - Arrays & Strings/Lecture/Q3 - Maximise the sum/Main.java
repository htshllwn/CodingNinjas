
// Given 2 sorted arrays (in increasing order),
// find a path through the intersections that produces maximum sum and return
// the maximum sum.
// That is, we can switch from one array to another array only at common
// elements.
// If no intersection element is present,
// we need to take sum of all elements from the array with greater sum.
// Input Format :
// Line 1 : An integer M i.e. size of first array
// Line 2 : M integers which are elements of first array, separated by spaces
// Line 3 : An integer N i.e. size of second array
// Line 4 : N integers which are elements of second array, separated by spaces
// Output Format :
// Maximum sum value
// Constraints :
// 1 <= M, N <= 10^6
// Sample Input :
// 6
// 1 5 10 15 20 25
// 5
// 2 4 5 9 15
// Sample Output :
// 81
// Sample Output Explanation :
// We start from array 2 and take sum till 5 (sum = 11).
// Then we'll switch to array at element 10 and take till 15.
// So sum = 36. Now, no elements left in array after 15,
// so we'll continue in array 1. Hence sum is 81

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int m = Integer.parseInt(reader.readLine());
        int[] mArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(reader.readLine());
        int[] nArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        long result = maximumSumPath(mArr, nArr);
        System.out.println(result);
    }

    public static long maximumSumPath(int[] input1, int[] input2) {
        long result = 0;
        int[] smaller = input1.length < input2.length ? input1 : input2;
        int[] larger = input1.length < input2.length ? input2 : input1;
        List<int[]> commons = new ArrayList<int[]>();
        long[] sumSmaller = calcSumArr(smaller);
        long[] sumLarger = calcSumArr(larger);

        for (int i = 0, j = 0; i < smaller.length; i++) {
            int index = findElement(larger, smaller[i], j);
            if (index > -1) {
                commons.add(new int[] { i, index });
                j = index + 1;
            }
        }
        commons.add(new int[] { smaller.length - 1, larger.length - 1 });

        int[] prev = { -1, -1 };
        for (int[] e : commons) {
            result += calcLargestSum(sumSmaller, sumLarger, e, prev);
            prev = e;
        }
        return result;
    }

    public static long calcLargestSum(long[] sum1, long[] sum2, int[] e, int[] prev) {
        long absSum1 = calcAbsSum(sum1, e[0], prev[0]);
        long absSum2 = calcAbsSum(sum2, e[1], prev[1]);
        return absSum1 > absSum2 ? absSum1 : absSum2;
    }

    public static long calcAbsSum(long[] sum, int e, int prev) {
        return prev == -1 ? sum[e] : sum[e] - sum[prev];
    }

    public static int findElement(int[] arr, int element, int index) {
        for (int i = index; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static long[] calcSumArr(int[] arr) {
        long[] sum = new long[arr.length];
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            sum[i] = tempSum;
        }
        return sum;
    }
}
