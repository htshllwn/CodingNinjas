// Given a boolean n*m matrix 
// (that contains 0 and 1 only), 
// you need to return the row number 
// which has maximum no. of 1s in it.
// Rows and columns are 0-indexed based. 
// If more than one row has same number of 1s, 
// print the row with lowest index.
// Input format :
// Line 1 : n and m (space separated positive integers)
// Next n lines : m elements of each row (separated by space).
// Output format :
// Line 1 : print row number
// Constraints :
// 1 <= n, m <= 10^4
// Sample Input 1 :
// 2 2 
// 0 1
// 1 1
// Sample Output 1 :
// 1

public class Main{
    public static void main(String[] args) {
        int[][] arr = {
            { 0, 1 },
            { 1, 1 }
        };

        System.out.println(max1(arr));
    }

    public static int max1(int arr[][]) {
        int max = 0, result = -1;
        for (int i = 0; i < arr.length; i++) {
            int c = 0;
            for (int j = 0; j < arr[i].length; j++) {
                c += arr[i][j] == 1 ? 1 : 0;
            }
            if (c > max) {
                max = c;
                result = i;
            }
        }
        return result;
	}
}
