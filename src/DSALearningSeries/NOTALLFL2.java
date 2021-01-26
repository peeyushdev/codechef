package DSALearningSeries;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NOTALLFL2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ai = new int[n];
            for (int i = 0; i < n; i++)
                ai[i] = sc.nextInt();
            int maxLength = 0;
            int[] lastIndexOfEveryK = new int[k];
            Set<Integer> uniqueK = new HashSet<>();
            int currentLength = 0;
            for (int i = 0; i < n; i++) {
                lastIndexOfEveryK[ai[i] - 1] = i;
                uniqueK.add(ai[i]);
                if (uniqueK.size() == k) {
                    maxLength = Math.max(maxLength, currentLength);
                    int kToBeRemoved = -1;
                    int indexOfKToBeRemoved = Integer.MAX_VALUE;
                    for (int j = 0; j < k; j++) {
                        if (indexOfKToBeRemoved > lastIndexOfEveryK[j]) {
                            kToBeRemoved = j + 1;
                            indexOfKToBeRemoved = lastIndexOfEveryK[j];
                        }
                    }
                    uniqueK.remove(kToBeRemoved);
                    currentLength = i - indexOfKToBeRemoved ;
                    continue;
                }
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
            System.out.println(maxLength);
        }
    }
}
