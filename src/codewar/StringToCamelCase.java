package codewar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringToCamelCase {
        static String toCamelCase(String s){
            String camelCaseOutput = "";
            for(int charactor=0;charactor<s.length();charactor++){
                if(s.charAt(charactor)=='_' || s.charAt(charactor)=='-'){
                    charactor++;
                    if((int)s.charAt(charactor) >90){
                        camelCaseOutput+=(char)(s.charAt(charactor)-32);
                    }else {
                        camelCaseOutput += s.charAt(charactor);
                    }
                }else{
                    camelCaseOutput+=s.charAt(charactor);
                }
            }
            return camelCaseOutput;
        }




}
