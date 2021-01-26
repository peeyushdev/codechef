package DSALearningSeries;

import java.util.Scanner;

public class PSHOT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int shootLeftA = n, shootLeftB = n;
            int goalScoredByA = 0, goalScoredByB = 0;
            boolean ansPrinted = false;
            String goalStreak = sc.next();
            for(int i=0;i<2*n;i++){
                if(i%2==0){
                    shootLeftA--;
                    if(goalStreak.charAt(i)=='1')
                        goalScoredByA++;
                }else{
                    shootLeftB--;
                    if(goalStreak.charAt(i)=='1')
                        goalScoredByB++;
                }
                if(goalScoredByA>(goalScoredByB+shootLeftB)||goalScoredByB>(goalScoredByA+shootLeftA)){
                    System.out.println(i+1);
                    ansPrinted=true;
                    break;
                }
            }
            if(!ansPrinted)
                System.out.println(2*n);
        }
    }
}
