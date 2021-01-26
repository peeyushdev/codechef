package GS;

import java.util.Scanner;

public class DFS {



//    public static int maxCost(int[][] grid){
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int maxRock = 0;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=0;j<grid.length-1;j++){
//                maxRock = Math.max(maxRock,maxCost(grid,i,j,0));
            }
        }
    }
}
