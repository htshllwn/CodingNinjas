// Given a number n, find number of numbers that are greater than n using the same set of digits as n. n might have duplicate digits.
// Input Format :
// Integer n
// Output Format :
// Count of greater numbers
// Sample Input :
// 122
// Sample Output :
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        long n = Long.parseLong(reader.readLine());

        System.out.println(numberOfNumbersWithDuplicates(n));
    }

    public static long numberOfNumbersWithDuplicates(long n) {
        int[] freq = new int[10];
        long num = n;
        ArrayList<Integer> list = new ArrayList<>();
        while (num != 0) {
            int digit = (int) num % 10;

            freq[digit]++;
            list.add(digit);
            num = num / 10;
        }
        int[] numArr = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            numArr[numArr.length - i - 1] = list.get(i);
        }
        HashMap<Integer, Integer> factorial = new HashMap<>();
        factorial.put(0, 1);
        for (int i = 1; i < 10; i++) {
            factorial.put(i, i * factorial.get(i - 1));
        }
        for (int i = 1; i < numArr.length; i++) {
            factorial.put(i, i * factorial.get(i - 1));
        }

        return numberOfNumbersWithDuplicates(numArr, freq, factorial);
    }

    public static long numberOfNumbersWithDuplicates(int[] num, int[] freq, HashMap<Integer, Integer> factorial) {
        if (num.length <= 1)
            return 0;
        long count = 0;
        long denominator = 1;

        for (int f : freq) {
            denominator *= factorial.get(f);
        }

        for (int i = num[0] + 1; i < 10; i++) {
            if (freq[i] > 0) {
                count += (factorial.get(num.length - 1) * freq[i]) / denominator;
            }
        }

        freq[num[0]]--;
        count += numberOfNumbersWithDuplicates(Arrays.copyOfRange(num, 1, num.length), freq, factorial);
        return count;
    }
}
