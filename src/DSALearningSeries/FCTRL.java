package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FCTRL {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            long numberOfXZeros = 0L;
            while(n>=5){
                n/=5;
                numberOfXZeros+=n;
            }
            System.out.println(numberOfXZeros);
        }
    }
}
