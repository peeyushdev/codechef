package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CONFLIP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int g = Integer.parseInt(br.readLine());
            while (g-- > 0) {
                String input = br.readLine();
                long I = Long.parseLong(input.split(" ")[0]);
                long N = Long.parseLong(input.split(" ")[1]);
                long Q = Long.parseLong(input.split(" ")[2]);
                if (N % 2 == 0) {
                    System.out.println(N / 2);
                } else {
                    if (I != Q) {
                        System.out.println(N / 2 + 1);
                    } else {
                        System.out.println(N / 2);
                    }
                }
            }
        }
    }
}
