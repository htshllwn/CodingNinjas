// Given a number n, print numbers from 1 to n in dictionary(lexicographical) order.
// Sample Input
// 20
// Sample Output
// 1
// 10
// 11
// 12
// 13
// 14
// 15
// 16
// 17
// 18
// 19
// 2
// 20
// 3
// 4
// 5
// 6
// 7
// 8
// 9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        lexicographicalOrder(n);
    }

    public static void lexicographicalOrder(int num) {
        for (int i = 1; i < 10; i++) {
            lexicographicalOrder(num, i);
        }
    }

    public static void lexicographicalOrder(int num, int temp) {
        if (temp > num)
            return;
        System.out.println(temp);
        for (int i = 0; i < 10; i++) {
            lexicographicalOrder(num, temp * 10 + i);
        }
    }
}
