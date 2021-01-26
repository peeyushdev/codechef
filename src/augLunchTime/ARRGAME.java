package augLunchTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ARRGAME {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] strip = new int[n];
            for(int i=0;i<n;i++)
                strip[i]=sc.nextInt();
            int len = -1;
            boolean seq = false;
            int len1 = 0;
            boolean same = false;
            int i = 1;
            while (i < strip.length) {
                if (strip[i]==0) {
                    if (!seq) {
                        len1 = 1;
                        seq = true;
                    } else {
                        len1++;
                    }
                } else {
                    seq = false;
                    if (len1 > len) {
                        len = len1;
                        same = false;
                    } else if (len1 == len) {
                        same = true;
                    }
                    len1 = 0;
                }
                i++;
            }
           if(same || len%2==0)
               System.out.println("No");
           else
               System.out.println("Yes");
        }
    }
}
