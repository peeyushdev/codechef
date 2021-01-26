package julyLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFSTR1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            long count = 0l;
            String strings = br.readLine();
            String[] intStrings = strings.split(" ");
            int prevString = Integer.parseInt(intStrings[0]);
            for(int i=1;i<intStrings.length;i++){
                count+=Math.abs(prevString - Integer.parseInt(intStrings[i]))-1;
                prevString = Integer.parseInt(intStrings[i]);
            }
            System.out.println(count);
        }
    }
}
