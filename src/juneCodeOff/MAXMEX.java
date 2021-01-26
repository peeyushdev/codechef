package juneCodeOff;

import java.util.HashSet;
import java.util.Scanner;

public class MAXMEX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            HashSet<Integer> smallElement = new HashSet<>();
            int len = 0;
            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > m) {
                    len += 1;
                } else if (arr[i] < m) {
                    len += 1;
                    smallElement.add(arr[i]);
                }
            }
            if (maxLen < len && smallElement.size() == m - 1)
                maxLen = len;
            if (maxLen > 0)
                System.out.println(maxLen);
            else
                System.out.println(-1);
        }
    }
}
