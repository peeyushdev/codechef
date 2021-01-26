package practise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class INTEG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        long x = sc.nextLong();
        long cost = 0L;
        int totalNegatives = 0;
        Map<Long, Long> negativeCountMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                totalNegatives++;
                long count = 0;
                if (negativeCountMap.containsKey((-1) * arr[i])) {
                    count = negativeCountMap.get((-1) * arr[i]);
                }
                count++;
                negativeCountMap.put((-1) * arr[i], count);
            }
        }
        long previousKey = 0;
        for(Map.Entry entry : negativeCountMap.entrySet()){
            if(totalNegatives >= x){
                cost+=(((long)entry.getKey())-previousKey)*x;
            }
            else{
                cost+=(((long)entry.getKey())-previousKey)*totalNegatives;
            }
            totalNegatives-=(long)entry.getValue();
            previousKey = (long) entry.getKey();
        }
        System.out.println(cost);
    }
}
