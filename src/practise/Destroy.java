package practise;

import java.util.*;

public class Destroy {
    public static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> mapToBeSorted) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(mapToBeSorted.entrySet());
        Collections.sort(list, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry entry : list) {
            sortedMap.put((int) entry.getKey(), (int) entry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> inputMap = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                int count = 0;
                int key = sc.nextInt();
                if (inputMap.containsKey(key)) {
                    count = inputMap.get(key);
                }
                count++;
                inputMap.put(key, count);
            }
            inputMap = sortMapByValue(inputMap);
            Set<Integer> keySet = inputMap.keySet();
            int minMoves = 0;
            while (keySet.size() > 1) {
                int totalUniqueKeys = inputMap.size();
                int firstKey = keySet.iterator().next();
                int firstKeyCount = inputMap.get(firstKey);
                int minCount = Math.min(totalUniqueKeys - 1, firstKeyCount);
                minMoves += minCount;
                inputMap.put(keySet.iterator().next(), firstKeyCount - minCount);
                Map<Integer, Integer> newMap = new LinkedHashMap<>();
                Iterator iterator = keySet.iterator();
                while (iterator.hasNext()) {
                    int key = (int) iterator.next();
                    if (key != firstKey && minCount > 0) {
                        minCount--;
                        inputMap.put(key, inputMap.get(key) - 1);
                    }
                    if (inputMap.get(key) != 0) {
                        newMap.put(key, inputMap.get(key));
                    }
                }
                inputMap = newMap;
//                inputMap = sortMapByValue(inputMap);
                keySet = inputMap.keySet();
            }
            if (inputMap.size() == 1) {
                minMoves += inputMap.get(keySet.iterator().next());
            }
            System.out.println(minMoves);
        }
    }
}
