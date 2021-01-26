package practise;

import java.util.Scanner;

public class CHEFTEAM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = Long.parseLong(sc.next());
            long k = Long.parseLong(sc.next());
            if (k > n || k == 0 || n == 0)
                System.out.println(0);
            else {
                if (n == k)
                    System.out.println(1);
                else {
                    long n1 = n;
                    long[] num = new long[(int) (n - k)];
                    long[] den = new long[(int) k];
                    int index = 0;
                    while (n1 > n - k) {
                        num[index] = n1;
                        n1--;
                        index++;
                    }
                    index = 0;
                    while (k > 0) {
                        boolean found = false;
                        for (int i = 0; i < num.length; i++) {
                            if (num[i] % k == 0) {
                                num[i] /= k;
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            den[index] = k;
                            index++;
                        }
                        k--;
                    }
                    long ans = 1L;
                    for (int i = 0; i < num.length; i++) {
                        ans *= num[i];
                    }
                    System.out.println(ans);
                }
            }
        }
    }
}
