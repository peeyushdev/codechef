package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CVOTE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        int n = Integer.parseInt(inputLine.split(" ")[0]);
        int m = Integer.parseInt(inputLine.split(" ")[1]);
        Map<String, String> nameAndCountryMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inputLine = br.readLine();
            nameAndCountryMap.put(inputLine.split(" ")[0], inputLine.split(" ")[1]);
        }
        Map<String, Integer> nameVotes = new HashMap<>();
        Map<String, Integer> countryVotes = new HashMap<>();
        for (int i = 0; i < m; i++) {
            inputLine = br.readLine();
            int nameCount = 0;
            int countryCount = 0;
            if(nameVotes.containsKey(inputLine)){
                nameCount=nameVotes.get(inputLine);
            }
            nameCount++;
            if(countryVotes.containsKey(nameAndCountryMap.get(inputLine))){
                countryCount = countryVotes.get(nameAndCountryMap.get(inputLine));
            }
            countryCount++;
            nameVotes.put(inputLine,nameCount);
            countryVotes.put(nameAndCountryMap.get(inputLine),countryCount);
        }
        TreeMap<Integer,TreeSet<String>> chefName = new TreeMap<>((o1,o2)->{return  -o1.compareTo(o2);});
        TreeMap<Integer,TreeSet<String>> chefCountry = new TreeMap<>((o1,o2)->{return  -o1.compareTo(o2);});
        for(Map.Entry entry : nameVotes.entrySet()){
            TreeSet<String> name = new TreeSet<>();
            if(chefName.containsKey(entry.getValue())){
                name = chefName.get(entry.getValue());
            }
            name.add(entry.getKey().toString());
            chefName.put(Integer.parseInt(entry.getValue().toString()),name);
        }
        for(Map.Entry entry : countryVotes.entrySet()){
            TreeSet<String> country = new TreeSet<>();
            if(chefCountry.containsKey(entry.getValue())){
                country = chefCountry.get(entry.getValue());
            }
            country.add(entry.getKey().toString());
            chefCountry.put(Integer.parseInt(entry.getValue().toString()),country);
        }
        System.out.println(chefCountry.entrySet().iterator().next().getValue().iterator().next());
        System.out.println(chefName.entrySet().iterator().next().getValue().iterator().next());
    }
}
