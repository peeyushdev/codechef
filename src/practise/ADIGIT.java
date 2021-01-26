package practise;

import java.util.Map;
import java.util.Scanner;

public class ADIGIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String num = sc.next();
        int[][] differences = new int[n][10];
        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(num.charAt(i) + "");
            int a1 = Math.abs(1 - d);
            int a2 = Math.abs(2 - d);
            int a3 = Math.abs(3 - d);
            int a4 = Math.abs(4 - d);
            int a5 = Math.abs(5 - d);
            int a6 = Math.abs(6 - d);
            int a7 = Math.abs(7 - d);
            int a8 = Math.abs(8 - d);
            int a9 = Math.abs(9 - d);
            int a10 = Math.abs(0 - d);
            differences[i][0] = a10;
            differences[i][1] = a1;
            differences[i][2] = a2;
            differences[i][3] = a3;
            differences[i][4] = a4;
            differences[i][5] = a5;
            differences[i][6] = a6;
            differences[i][7] = a7;
            differences[i][8] = a8;
            differences[i][9] = a9;
            if (i > 0) {
                differences[i][0] += differences[i - 1][0];
                differences[i][1] += differences[i - 1][1];
                differences[i][2] += differences[i - 1][2];
                differences[i][3] += differences[i - 1][3];
                differences[i][4] += differences[i - 1][4];
                differences[i][5] += differences[i - 1][5];
                differences[i][6] += differences[i - 1][6];
                differences[i][7] += differences[i - 1][7];
                differences[i][8] += differences[i - 1][8];
                differences[i][9] += differences[i - 1][9];
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int digit = Integer.parseInt(num.charAt(x) + "");
            if (x == 0)
                System.out.println(0);
            else
                System.out.println(differences[x][digit]);
        }
    }
}
