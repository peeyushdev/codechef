package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CARVANS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            String[] speeds = br.readLine().split(" ");
            int previousSpeed = Integer.parseInt(speeds[0]);
            int maxSpeedCars = 1;
            for(String car : speeds){
                if(previousSpeed<Integer.parseInt(car))
                    continue;
                maxSpeedCars++;
                previousSpeed=Integer.parseInt(car);
            }
            System.out.println(maxSpeedCars-1);
        }
    }
}
