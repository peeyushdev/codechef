package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PSHOT{

    public static boolean goalScored(char goalResult){
        if(goalResult=='1')
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =  Integer.parseInt(br.readLine());
        while(t-- >0){
            int totalShoots =  Integer.parseInt(br.readLine());
            int shootsTakenByA = 0;
            int shootsTakenByB = 0;
            int goalScoredByA = 0;
            int goalScoredByB = 0;
            int decidingGoal = -1;
            StringBuilder goalStreak = new StringBuilder(br.readLine());
            for(int i=0;i<goalStreak.length();i++){
                if(i%2==0){
                    shootsTakenByA++;
                    if(goalScored(goalStreak.charAt(i))){
                        goalScoredByA++;
                    }
                }else {
                    shootsTakenByB++;
                    if(goalScored(goalStreak.charAt(i))){
                        goalScoredByB++;
                    }
                }
                if(goalScoredByA>goalScoredByB+(totalShoots-shootsTakenByB)){
                    decidingGoal=i+1;
                    break;
                }
                if(goalScoredByB>goalScoredByA+(totalShoots-shootsTakenByA)){
                    decidingGoal=i+1;
                    break;
                }
            }
            if(decidingGoal==-1)
                decidingGoal=2*totalShoots;
            System.out.println(decidingGoal);
        }
    }

}
