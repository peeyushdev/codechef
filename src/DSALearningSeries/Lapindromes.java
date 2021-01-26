package DSALearningSeries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lapindromes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String inputString = sc.next();
            Map<Character, Integer> characterIntegerMap = new HashMap<>();
            for (int index = 0; index <inputString.length()/2; index++) {
                int frequencyOfChar = 0;
                if (characterIntegerMap.containsKey(inputString.charAt(index))) {
                    frequencyOfChar = characterIntegerMap.get(inputString.charAt(index));
                }
                frequencyOfChar++;
                characterIntegerMap.put(inputString.charAt(index), frequencyOfChar);
            }
            boolean isLapindrome = true;
            for (int index = inputString.length()%2==0?inputString.length()/2:inputString.length()/2+1; index < inputString.length(); index++) {
                if (!characterIntegerMap.containsKey(inputString.charAt(index))) {
                    isLapindrome = false;
                    break;
                }
                characterIntegerMap.put(inputString.charAt(index), characterIntegerMap.get(inputString.charAt(index)) - 1);
            }
            if(!isLapindrome)
                System.out.println("NO");
            else{
                for(Map.Entry characterFrequency: characterIntegerMap.entrySet()){
                    if((int)characterFrequency.getValue()==0){
                        continue;
                    }
                    isLapindrome=false;
                    break;
                }
                if(!isLapindrome)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            }

        }
    }
}
