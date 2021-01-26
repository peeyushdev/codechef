package JuneLongChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class COVDSMPL_2 {

    public static int grader(int r1, int c1, int r2, int c2) {
        Scanner sc = new Scanner(System.in);
        StringBuilder interaction = new StringBuilder();
        interaction.append(1);
        interaction.append(" " + r1 + " " + c1 + " " + r2 + " " + c2);
        System.out.println(interaction);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            StringBuilder ans = new StringBuilder();
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(matrix[i], -1);
            Map<Integer, Integer> rowMap = new HashMap<>();
            Map<Integer, Integer> colMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int r1 = i + 1;
                int c1 = 1;
                int r2 = r1;
                int c2 = n;
                int rowOutput = grader(r1, c1, r2, c2);
                rowMap.put(i, rowOutput);
            }
            for (int i = 0; i < n; i++) {
                int r1 = 1;
                int c1 = i + 1;
                int r2 = n;
                int c2 = c1;
                int colOutput = grader(r1, c1, r2, c2);
                colMap.put(i, colOutput);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (rowMap.get(i) == 0) {
                        matrix[i][j] = 0;
                    } else if (rowMap.get(i) == n) {
                        matrix[i][j] = 1;
                    }
                    if (colMap.get(j) == 0) {
                        matrix[i][j] = 0;
                    } else if (colMap.get(j) == n) {
                        matrix[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] > -1)
                        continue;
                    int r1 = i + 1;
                    int c1 = j + 1;
                    int r2 = r1;
                    int c2 = c1;
                    boolean isRowOrCol = false;
                    if (rowMap.get(i) == n - j || rowMap.get(i) == 0) {
                        if (rowMap.get(i) == 0)
                            matrix[i][j] = 0;
                        else {
                            matrix[i][j] = 1;
                            rowMap.put(i, rowMap.get(i) - 1);
                            colMap.put(j,colMap.get(j)-1);
                        }
                        isRowOrCol = true;
                    }
                    else if (colMap.get(j) == n - i || colMap.get(j) == 0) {
                        if (colMap.get(j) == 0)
                            matrix[i][j] = 0;
                        else {
                            matrix[i][j] = 1;
                            colMap.put(j, colMap.get(j) - 1);
                            rowMap.put(i,rowMap.get(i)-1);
                        }
                        isRowOrCol = true;
                    }
                    if (!isRowOrCol) {
                        int output = grader(r1, c1, r2, c2);
                        if(output == 0){
                            matrix[i][j]=0;
                        }
                        else{
                            matrix[i][j]=1;
                            rowMap.put(i,rowMap.get(i)-1);
                            colMap.put(j,colMap.get(j)-1);
                        }
                    }
                }
            }
            ans.append("2\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    ans.append(matrix[i][j]+" ");
                ans.append("\n");
            }
            System.out.println(ans);
            int x = sc.nextInt();
            if(x==-1)
                System.exit(-1);
        }
    }
}
