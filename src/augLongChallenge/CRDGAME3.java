package augLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CRDGAME3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            int pC = Integer.parseInt(input.split(" ")[0]);
            int pR = Integer.parseInt(input.split(" ")[1]);
            long digitC;
            long digitR;
            digitC = (long) Math.ceil(pC/9D);
            digitR = (long) Math.ceil(pR/9D);
            if(digitC==digitR)
                System.out.println("1 "+digitR);
            else if(digitC < digitR)
                System.out.println("0 "+digitC);
            else
                System.out.println("1 "+digitR);
        }
    }
}

