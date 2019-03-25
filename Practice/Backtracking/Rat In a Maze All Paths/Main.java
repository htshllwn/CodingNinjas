
// You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
// Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
// Input Format
// Line 1 : Integer N
// Next N Lines : Each line will contain ith row elements (separated by space)
// Output Format :
// One Line for every possible solution. 
// Every line will have N*N maze elements printed row wise and are separated by space. Only cells that are part of solution path should be 1, rest all cells should be 0.
// Sample Input 1 :
// 3
// 1 0 1
// 1 0 1
// 1 1 1
// Sample Output 1 :
// 1 0 0 1 0 0 1 1 1 
// Sample Output 1 Explanation :
// Only 1 path is possible
// Sample Input 2 :
// 3
// 1 0 1
// 1 1 1
// 1 1 1
// Sample Output 2 :
// 1 0 0 1 1 1 1 1 1 
// 1 0 0 1 0 0 1 1 1 
// 1 0 0 1 1 0 0 1 1 
// 1 0 0 1 1 1 0 0 1 
// Sample Output 2 Explanation :
// 4 paths are possible

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = reader.readLine();
            String[] strArr = str.split("\\s");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        ratInAMaze(arr);
    }

    public static void ratInAMaze(int maze[][]) {
        int[][] visited = new int[maze.length][maze.length];

        printAllPaths(maze, visited, 0, 0);
    }

    public static void printAllPaths(int maze[][], int visited[][], int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze.length || visited[x][y] == 1 || maze[x][y] == 0) {
            return;
        }

        if (x == maze.length - 1 && y == maze.length - 1) {
            visited[x][y] = 1;
            for (int[] arr : visited) {
                for (int i : arr) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            visited[x][y] = 0;
            return;
        }

        visited[x][y] = 1;
        printAllPaths(maze, visited, x - 1, y);
        printAllPaths(maze, visited, x + 1, y);
        printAllPaths(maze, visited, x, y - 1);
        printAllPaths(maze, visited, x, y + 1);

        visited[x][y] = 0;
    }
}
