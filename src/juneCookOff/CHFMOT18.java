package juneCookOff;

import java.io.*;
import java.util.Scanner;

public class CHFMOT18 {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            String input = br.readLine();
            int s = Integer.parseInt(input.split(" ")[0]);
            int n = Integer.parseInt(input.split(" ")[1]);
            long numberOfCoinsRequired = 0;
            while (n >= 2 && s >1) {
                if (s / n > 0) {
                    numberOfCoinsRequired += s / n;
                    s -= (s / n) * n;
                }
                if(s%2==0)
                    n=s;
                else
                    n=s-1;
            }
            if (s > 0) {
                numberOfCoinsRequired += s;
            }
            out.append(numberOfCoinsRequired+"\n");
        }
        System.out.println(out);
    }
}
