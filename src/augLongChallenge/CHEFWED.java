package augLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CHEFWED {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            String line = br.readLine();
            int n = Integer.parseInt(line.split(" ")[0]);
            int k = Integer.parseInt(line.split(" ")[1]);
            int[] arr = new int[n];
            line = br.readLine();
            for(int i=0;i<line.split(" ").length;i++)
                arr[i]= Integer.parseInt(line.split(" ")[i]);
           long totalCost = k;
           long conflicts =1L;
           Map<Integer,Integer> map = new HashMap<>();
           for(int i=0;i<arr.length;i++){
               if(map.containsKey(arr[i])){
                   int count = map.get(arr[i]);
                   if(count+1>=k || (conflicts==k && i<n-2)){
                       totalCost+=k;
                       map.clear();
                       conflicts=1L;
                       map.put(arr[i],1);
                   }
                   else{
                       if(count>1){
                        totalCost-=count;
                       }
                       count++;
                       totalCost+=count;
                       conflicts++;
                       map.put(arr[i],count);
                   }
               }else{
                   map.put(arr[i],1);
               }
           }
            System.out.println(totalCost);
        }
    }
}
