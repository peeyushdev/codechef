package julyLunchTime;

import java.util.Scanner;

public class CHECHOC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long maxCandy;
            long step1 = Math.min(x, y);
            long step2 = Math.min(y - step1, x);
            long totalElm = n * m;
            if (totalElm == 1)
                System.out.println(x);
            else {
                long elm1, elm2;
                elm1 = (long) Math.ceil(totalElm / 2D);
                elm2 = totalElm / 2;
                maxCandy = (elm1 * step1) + (elm2 * step2);
                System.out.println(maxCandy);
            }
        }
    }
}
