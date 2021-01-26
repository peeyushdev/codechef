package augLunchTime;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MODEFREQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                int count = 0;
                int n1 = sc.nextInt();
                if(map.containsKey(n1)){
                    count = map.get(n1);
                }
                count++;
                map.put(n1,count);
            }
            Map<Integer,Integer> freq = new HashMap<>();
            for(Map.Entry entry : map.entrySet()){
                int value = (int) entry.getValue();
                int count =0 ;
                if(freq.containsKey(value))
                    count = freq.get(value);
                count++;
                freq.put(value,count);
            }
            Pair pair = new Pair(Integer.MAX_VALUE, 0);
            for(Map.Entry entry:freq.entrySet()){
                int key = (int) entry.getKey();
                int value = (int) entry.getValue();
                if(value == pair.getCount()){
                    if(key < pair.getValue())
                        pair = new Pair(key,value);
                }
                if(value > pair.getCount()){
                    pair = new Pair(key,value);
                }
            }
            System.out.println(pair.getValue());
        }
    }


    static class Pair{
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }

        public int getValue() {
            return value;
        }

        public int getCount() {
            return count;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
