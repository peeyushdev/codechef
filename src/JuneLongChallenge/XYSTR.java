package JuneLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class XYSTR {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int count=1;
            String s = br.readLine();
            if(s.indexOf('x')<0 || s.indexOf('y')<0)
                System.out.println(0);
            else{
                int pairs=0;
                for(int i=0;i<s.length()-1;i++){
                    if(s.charAt(i)!=s.charAt(i+1)){
                        pairs++;
                        i++;
                    }
                }
                System.out.println(pairs);
            }
        }
    }
}
