package codewar;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {

    static String encode(String word){
        word=word.toLowerCase();
        StringBuilder encodedString = new StringBuilder();
        Map<Character,Integer> characterMap = new HashMap<Character,Integer>();
        for(char charactor : word.toCharArray()){
            int count = 0;
            if(characterMap.containsKey(charactor)){
                count = characterMap.get(charactor);
            }
            count++;
            characterMap.put(charactor,count);
        }
        for(char charactor : word.toCharArray()){
            if(characterMap.get(charactor) > 1){
                encodedString.append(")");
            }else{
                encodedString.append("(");
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("Prespecialized"));
    }
}
