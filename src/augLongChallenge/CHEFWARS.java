package augLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFWARS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            int h = Integer.parseInt(input.split(" ")[0]);
            int p = Integer.parseInt(input.split(" ")[1]);
            long totalPower = 0L;
            while (p > 0) {
                totalPower += p;
                p /= 2;
                if(totalPower > h)
                    break;
            }
            if (totalPower >h)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
