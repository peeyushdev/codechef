package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class PLAYFIT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String matches = br.readLine();
            String[] goals = matches.split(" ");
            int minGoals[] = new int[n];
            int maxGoals[] = new int[n];
            minGoals[0]=Integer.parseInt(goals[0]);
            for(int i=1;i<n;i++){
                minGoals[i]= Math.min(minGoals[i-1], Integer.parseInt(goals[i]));
            }
            maxGoals[n-1]=Integer.parseInt(goals[n-1]);
            for(int i=n-2;i>=0;i--){
                maxGoals[i]=Math.max(maxGoals[i+1], Integer.parseInt(goals[i]));
            }
            long score = 0L;
            for(int i=0;i<n;i++){
                score = Math.max(score, maxGoals[i]-minGoals[i]);
            }
            if(score>0){
                System.out.println(score);
            }
            else
                System.out.println("UNFIT");

        }
    }
}
