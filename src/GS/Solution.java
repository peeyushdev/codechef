package GS;

import java.util.*;

public class Solution {

    static int countSpecialElements(List<List<Integer>> matrix) {
        int[] minRow = new int[matrix.size()];
        int[] maxRow = new int[matrix.size()];
        int[] minCol = new int[matrix.get(0).size()];
        int[] maxCol = new int[matrix.get(0).size()];
        int countOfPosition = 0;
        for(int i=0;i<maxRow.length;i++){
            maxRow[i]=matrix.get(i).get(0);
            minRow[i]=maxRow[i];
            for(int j=1;j<matrix.get(i).size();j++){
                maxRow[i]= Math.max(maxRow[i],matrix.get(i).get(j));
                minRow[i]= Math.min(minRow[i],matrix.get(i).get(j));
            }
        }
        for(int i=0;i<maxCol.length;i++){
            maxCol[i]=matrix.get(0).get(i);
            minCol[i]=maxCol[i];
            for(int j=1;j<matrix.get(0).size();j++){
                maxCol[i]= Math.max(maxCol[i],matrix.get(j).get(i));
                minCol[i]= Math.min(minCol[i],matrix.get(j).get(i));
            }
        }
       Set<Integer> colFound = new HashSet<>();
       Set<Integer> rowFound = new HashSet<>();
       boolean duplicate = false;
       for(int i=0;i<matrix.size();i++){
           for (int j=0;j<matrix.get(i).size();j++){
               if(matrix.get(i).get(j)==minRow[i] || matrix.get(i).get(j)==maxRow[i]){
//                   if(rowFound.contains(i)){
//                       duplicate=true;
//                       break;
//                   }
                   countOfPosition++;
               }
               else if(matrix.get(i).get(j)==minCol[j] || matrix.get(i).get(j)==maxCol[j]){
//                   if(colFound.contains(i)){
//                       duplicate=true;
//                       break;
//                   }
                   countOfPosition++;
               }
           }
           if(duplicate)
               break;
       }
       if(duplicate)
           return -1;
       return countOfPosition;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }
        int count = countSpecialElements(matrix);
        System.out.println(count);
    }
}
