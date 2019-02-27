// Given a two dimensional n*m array, 
// print the array in a sine wave order. 
// i.e. print the first column top to bottom, 
// next column bottom to top and so on.
// Note : Print the elements separated by space.
// Input format :
// n, m, array elements (separated by space)
// Sample Input :
// 3 4 1  2  3  4 5  6  7  8 9 10 11 12
// Sample Output :
// 1 5 9 10 6 2 3 7 11 12 8 4

public class Main {
    public static void main(String[] args) {
        int input[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        wavePrint(input);
    }

    public static void wavePrint(int input[][]){
        int c = 0;
        for (int j = 0; j < input[0].length; j++) {
            for (int i = 0; i < input.length; i++) {
                System.out.print(input[Math.abs(c - i)][j] + " ");
            }
            c = c == 0 ? input.length - 1 : 0;
        }
	}
}