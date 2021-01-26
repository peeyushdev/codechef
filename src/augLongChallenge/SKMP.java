package augLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SKMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            int[] countAlpha = new int[26];
            boolean isSmall = false;
            for (int i = 0; i < s1.length(); i++) {
                countAlpha[s1.charAt(i) - 97]++;
            }
            int diff_i = -1;
            for (int i = 0; i < s2.length(); i++) {
                if(i>0 && s2.charAt(i)!=s2.charAt(0)&&diff_i==-1)
                    diff_i=i;
                countAlpha[s2.charAt(i) - 97]--;
            }
            if(diff_i==-1)
                diff_i=0;
            if(s2.charAt(diff_i)<s2.charAt(0))
                isSmall=true;
            int i = 0;
            StringBuilder output = new StringBuilder();
            while (i < 26 && ((char) i + 97) < s2.charAt(0)) {
                while (countAlpha[i] > 0) {
                    char alpha = (char) (i + 97);
                    output.append(alpha);
                    countAlpha[i]--;
                }
                i++;
            }
            if(((char)i+97)==s2.charAt(0)){
                if(!isSmall){
                    while(countAlpha[i]>0){
                        char alpha = (char) (i+97);
                        output.append(alpha);
                        countAlpha[i]--;
                    }
                }
            }
            output.append(s2);
            while (i < 26) {
                while (countAlpha[i] > 0) {
                    char alpha = (char) (i + 97);
                    output.append(alpha);
                    countAlpha[i]--;
                }
                i++;
            }
            System.out.println(output);
        }
    }
}
