package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HDELIVER {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            int n = Integer.parseInt(input.split(" ")[0]);
            int m = Integer.parseInt(input.split(" ")[1]);
            int[][] fastRoadMatrix = new int[n][n];
            Map<Integer, Set<Integer>> inputMap = new HashMap<>();
            for (int i = 0; i < m; i++) {
                input = br.readLine();
                int x = Integer.parseInt(input.split(" ")[0]);
                int y = Integer.parseInt(input.split(" ")[1]);
                Set<Integer> fastRoades = new HashSet<>();
                if (inputMap.containsKey(x)) {
                    fastRoades = inputMap.get(x);
                }
                fastRoades.add(y);
                inputMap.put(x, fastRoades);
            }
            Map<Integer, Set<Integer>> fastRoadMap = inputMap;
            for (Map.Entry entry : inputMap.entrySet()) {
                Set<Integer> indexes = (Set<Integer>) entry.getValue();
                if (indexes.size() == n - 1) {
                    continue;
                }
                Iterator itr = indexes.iterator();
                while (itr.hasNext()) {
                    int key = (int) itr.next();
                    if (!inputMap.containsKey(key)) {
                        continue;
                    }
                    Set<Integer> possibelIndex = inputMap.get(key);
                    possibelIndex.forEach(index -> {
                        if (!indexes.contains(index)) {
                            indexes.add(index);
                        }
                    });
                }
                fastRoadMap.put((Integer) entry.getKey(), indexes);
            }

            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                input = br.readLine();
                int x = Integer.parseInt(input.split(" ")[0]);
                int y = Integer.parseInt(input.split(" ")[1]);
                if ((fastRoadMap.containsKey(x) && fastRoadMap.get(x).contains(y)) || (fastRoadMap.containsKey(y) && fastRoadMap.get(y).contains(x))) {
                    System.out.println("YO");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }
}


//            for (int i = 0; i < n; i++) {
//                for (int j = i+1; j < n; j++) {
//                    if (fastRoadMatrix[i][j] != 1 && i != j) {
//                        if (inputMap.containsKey(i) && inputMap.get(i).contains(j)) {
//                            fastRoadMatrix[i][j] = 1;
//                        }
//                    }
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                for (int j = i+1; j < n; j++) {
//                    if (fastRoadMatrix[i][j] == 1 && i != j) {
//                        int finalI = i;
//                        if (inputMap.containsKey(j)) {
//                            inputMap.get(j).forEach(index -> {
//                                if (finalI != index) {
//                                    fastRoadMatrix[finalI][index] = 1;
//                                }
//                            });
//                        }
//                    }
//                }
//            }
