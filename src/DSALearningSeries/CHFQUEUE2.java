package DSALearningSeries;

import java.util.*;

public class CHFQUEUE2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] seniority = new int[n];
        for (int i = 0; i < n; i++) {
            seniority[i] = sc.nextInt();
        }
        long output = 1;
        int[] minSeniorty = new int[n];
        minSeniorty[n - 1] = seniority[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSeniorty[i] = Math.min(minSeniorty[i + 1], seniority[i]);
        }
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (minSeniorty[i] >= seniority[i])
                continue;
            if(i>0 && seniority[i]==seniority[i-1] && minIndex!=-1){
                output *= ((minIndex - i + 1) % 1000000007);
                output %= 1000000007;
                continue;
            }
            minIndex=-1;
            for (int j = i + 1; j < n; j++) {
                if (seniority[j] < seniority[i]) {
                    minIndex = j;
                    break;
                }
            }
            output *= ((minIndex - i + 1) % 1000000007);
            output %= 1000000007;
        }
        System.out.println(output % 1000000007);
    }
}


/*
* 10 4
4 2 3 2 1 4 3 3 2 1*/