package practise;

import java.util.Scanner;

public class CHEFLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long sqrtOfN = (long) Math.sqrt(n);
            long sumOfFactors = 0L;
            for(long factor=1;factor<=sqrtOfN;factor++){
                if(n%factor == 0){
                    if(factor == n/factor){
                        sumOfFactors+=factor;
                    }else{
                        sumOfFactors+=factor;
                        sumOfFactors+=n/factor;
                    }
                }
            }
            System.out.println(sumOfFactors);
        }
    }
}
