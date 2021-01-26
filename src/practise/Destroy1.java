package practise;

import java.util.*;

public class Destroy1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> inputMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int count = 0;
                int key = sc.nextInt();
                if (inputMap.containsKey(key)) {
                    count = inputMap.get(key);
                }
                count++;
                inputMap.put(key, count);
            }
            Map<Integer, Integer> reduceMap = new HashMap<>();
            for (Map.Entry entry : inputMap.entrySet()) {
                int key = (int) entry.getValue();
                int count = 0;
                if(reduceMap.containsKey(key)){
                    count = reduceMap.get(key);
                }
                count++;
                reduceMap.put(key,count);
            }
            int moves = 0;
            for(Map.Entry entry : reduceMap.entrySet()){
                moves = moves + (int) entry.getValue() /2;
                reduceMap.put((int) entry.getKey(),(int)entry.getValue()-(int)entry.getValue()/2);
            }
            System.out.println(reduceMap);
            System.out.println(moves);
        }
    }
}
