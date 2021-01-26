package julyLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CRDGAME {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long pointsA = 0;
            long pointsB = 0;
            for (int i = 0; i < n; i++) {
                String round = br.readLine();
                long cardA = Long.parseLong(round.split(" ")[0]);
                long cardB = Long.parseLong(round.split(" ")[1]);
                long degA = 0;
                long degB = 0;
                while(cardA>0){
                    degA+=cardA%10;
                    cardA/=10;
                }
                while(cardB>0){
                    degB+=cardB%10;
                    cardB/=10;
                }
                if(degA>degB)
                    pointsA++;
                else if(degB>degA)
                    pointsB++;
                else{
                    pointsA++;
                    pointsB++;
                }
            }
            if(pointsA>pointsB)
                System.out.println("0 "+pointsA);
            else if(pointsB > pointsA)
                System.out.println("1 "+pointsB);
            else
                System.out.println("2 "+pointsA);
        }
    }
}
