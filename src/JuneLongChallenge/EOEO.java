package JuneLongChallenge;

import java.util.Scanner;

public class EOEO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            long TS = sc.nextLong();
            long res = TS & TS-1;
            if(res == 0){
                System.out.println(0);
            }
            else if(TS % 2!=0){
                System.out.println(TS/2);
            }
            else{
                int even = 0;
                long initial_TS = TS;
                while(TS%2==0){
                    TS/=2;
                    even++;
                }
                long maxCount = initial_TS / (long) Math.pow(2,even+1);
                System.out.println(maxCount);
            }
        }
    }
}
