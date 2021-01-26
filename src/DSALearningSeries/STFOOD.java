package DSALearningSeries;

import java.util.Scanner;

public class STFOOD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            long maxProfit = 0L;
            for(int i=0;i<n;i++){
                int s = sc.nextInt();
                int p = sc.nextInt();
                int v = sc.nextInt();
                maxProfit = Math.max(maxProfit,(p/(s+1))*v);
            }
            System.out.println(maxProfit);
        }
    }
}
