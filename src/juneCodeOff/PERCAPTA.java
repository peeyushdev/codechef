package juneCodeOff;

import sun.jvm.hotspot.code.ScopeValue;

import java.util.ArrayList;
import java.util.Scanner;

public class PERCAPTA {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n  = sc.nextInt();
            int m  = sc.nextInt();
            int[] income = new int[n];
            int[] population = new int[n];
            for(int i=0;i<n;i++){
                income[i]=sc.nextInt();
            }for(int i=0;i<n;i++){
                population[i]=sc.nextInt();
            }
            int[][] connection = new int[m][2];
            for(int i=0;i<m;i++){
                connection[i][0]=sc.nextInt();
                connection[i][1]=sc.nextInt();
            }
            int percapita = 0;
            int maxpercapita =0;
            ArrayList<Integer> elemnt = new ArrayList<>();
            for(int i=0;i<m;i++){
                ArrayList<Integer> currentElemnt = new ArrayList<>();
                percapita = income[connection[i][0]-1]/population[connection[i][0]-1];
                currentElemnt.add(connection[i][0]);

            }
        }
    }
}
