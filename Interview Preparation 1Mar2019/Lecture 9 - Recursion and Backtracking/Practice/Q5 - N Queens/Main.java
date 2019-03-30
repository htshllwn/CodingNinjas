// You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
// Input Format :
// Line 1 : Integer N
// Output Format :
// One Line for every board configuration. 
// Every line will have N*N board elements printed row wise and are separated by space
// Note : Don't print anything if there isn't any valid configuration.
// Constraints :
// 1<=N<=10
// Sample Input 1:
// 4
// Sample Output 1 :
// 0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
// 0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        placeNQueens(n);
    }

    public static void placeNQueens(int n) {
        int[][] board = new int[n][n];
        placeNQueens(board);
    }

    public static void placeNQueens(int[][] board) {
        int i = 0;
        for (int j = 0; j < board.length; j++) {
            placeNQueens(i, j, board);
        }
    }

    public static void placeNQueens(int i, int j, int[][] board) {
        if (board[i][j] != 0) {
            return;
        }
        placeQueen(i, j, board, -1);
        if (i == board.length - 1) {
            printBoard(board);
            placeQueen(i, j, board, 1);
            return;
        }
        for (int x = 0; x < board.length; x++) {
            placeNQueens(i + 1, x, board);
        }
        placeQueen(i, j, board, 1);
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] < 1) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
        }
        System.out.println();
    }

    public static void placeQueen(int i, int j, int[][] board, int v) {
        if (v == -1) {
            board[i][j] = 1;
        } else {
            board[i][j] = 0;
        }
        for (int x = i + 1; x < board.length; x++) {
            board[x][j] += v;
        }
        for (int x = i - 1; x >= 0; x--) {
            board[x][j] += v;
        }
        for (int y = j + 1; y < board.length; y++) {
            board[i][y] += v;
        }
        for (int y = j - 1; y >= 0; y--) {
            board[i][y] += v;
        }
        for (int x = i + 1, y = j + 1; x < board.length && y < board.length; x++, y++) {
            board[x][y] += v;
        }
        for (int x = i + 1, y = j - 1; x < board.length && y >= 0; x++, y--) {
            board[x][y] += v;
        }
        for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
            board[x][y] += v;
        }
        for (int x = i - 1, y = j + 1; x >= 0 && y < board.length; x--, y++) {
            board[x][y] += v;
        }
    }
}