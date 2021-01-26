package juneCookOff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class INCRDEC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] output = new int[n];
            for (int i = 0; i < n; i++)
                arr[i]=sc.nextInt();
            Arrays.sort(arr);
            boolean[] isTaken = new boolean[n];
            output[0]=arr[0];
            isTaken[0] = true;
            boolean isPossible = true;
            int cuurentIndex=1;
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1])
                    continue;
                output[cuurentIndex]=arr[i];
                cuurentIndex++;
                isTaken[i] = true;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (isTaken[i])
                    continue;
                else {
                    if (output[cuurentIndex-1] == arr[i]) {
                        isPossible = false;
                        break;
                    } else {
                        output[cuurentIndex]=arr[i];
                        cuurentIndex++;
                        isTaken[i] = true;
                    }
                }
            }
            if (!isPossible)
                System.out.println("NO");
            else {
                System.out.println("YES");
                StringBuilder out = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    out.append(output[i] + " ");
                }
                System.out.println(out);
            }
        }
    }
}