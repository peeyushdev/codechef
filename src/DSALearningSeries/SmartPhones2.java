package DSALearningSeries;

import java.math.BigInteger;
import java.util.*;

public class SmartPhones2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> budgets =  new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
            budgets.add(sc.nextLong());
        Collections.sort(budgets);
        long maxRevenue = 0L;
        long size =  budgets.size();
        for(long budget : budgets){
            maxRevenue=Math.max(maxRevenue,budget*size);
            size--;
        }
        System.out.println(maxRevenue);
    }

}
