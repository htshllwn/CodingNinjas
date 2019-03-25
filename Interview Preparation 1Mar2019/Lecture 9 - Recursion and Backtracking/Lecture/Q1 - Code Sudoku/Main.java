// Given a 9*9 sudoku board, in which some entries are filled and others are 0 (0 indicates that the cell is empty), you need to find out whether the Sudoku puzzle can be solved or not i.e. return true or false.
// Input Format :
// 9 Lines where ith line contains ith row elements separated by space
// Output Format :
//  true or false
// Sample Input :
// 9 0 0 0 2 0 7 5 0 
// 6 0 0 0 5 0 0 4 0 
// 0 2 0 4 0 0 0 1 0 
// 2 0 8 0 0 0 0 0 0 
// 0 7 0 5 0 9 0 6 0 
// 0 0 0 0 0 0 4 0 1 
// 0 1 0 0 0 5 0 8 0 
// 0 9 0 0 7 0 0 0 4 
// 0 8 2 0 4 0 0 0 6
// Sample Output :
// true

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = 9;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = reader.readLine();
            String[] strArr = str.split("\\s");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        System.out.println(sudokuSolver(arr));
    }

    public static boolean sudokuSolver(int board[][]) {
        return sudokuSolver(board, 0, 0);
    }

    public static boolean sudokuSolver(int board[][], int i, int j) {
        if (j == board.length) {
            j = 0;
            i = i + 1;
        }
        if (i >= board.length)
            return true;
        if (board[i][j] > 0) {
            return sudokuSolver(board, i, j + 1);
        }

        HashMap<Integer, Boolean> presentNumbers = getPresentDigits(board, i, j);

        for (int z = 1; z <= 9; z++) {
            if (!presentNumbers.containsKey(z)) {
                board[i][j] = z;
                if (sudokuSolver(board, i, j + 1))
                    return true;
            }
        }
        board[i][j] = 0;
        return false;
    }

    public static HashMap<Integer, Boolean> getPresentDigits(int[][] board, int i, int j) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int x = 0; x < board.length; x++) {
            if (board[i][x] > 0)
                map.put(board[i][x], true);
            if (board[x][j] > 0)
                map.put(board[x][j], true);
        }

        int[] box = getBoxIndices(i, j);

        for (int x = box[0]; x < box[0] + 3; x++) {
            for (int y = box[1]; y < box[1] + 3; y++) {
                if (board[x][y] > 0)
                    map.put(board[x][y], true);
            }
        }

        return map;
    }

    public static int[] getBoxIndices(int i, int j) {
        int[] box = new int[2];
        int x = 0, y = 0;
        int boxSize = 3;
        while (boxSize * x <= i)
            x++;
        while (boxSize * y <= j)
            y++;
        box[0] = boxSize * (x - 1);
        box[1] = boxSize * (y - 1);
        return box;
    }
}
