package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZCO12002 {
    public static void main(String[] args) throws IOException { ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int x = Integer.parseInt(line1.split(" ")[1]);
        int y = Integer.parseInt(line1.split(" ")[2]);
        int time = Integer.MAX_VALUE;
        int[][] contest = new int[n][2];
        for(int i=0;i<n;i++){
            line1 = br.readLine();
            contest[i][0]= Integer.parseInt(line1.split(" ")[0]);
            contest[i][1]= Integer.parseInt(line1.split(" ")[1]);
        }
        int[] v = new int[x];
        int[] w = new int[y];
        line1 = br.readLine();
        for(int i=0;i<x;i++){
            v[i]=  Integer.parseInt(line1.split(" ")[i]);
        }
        line1 = br.readLine();
        for(int i=0;i<y;i++){
            w[i]=  Integer.parseInt(line1.split(" ")[i]);
        }

        Arrays.sort(v);
        Arrays.sort(w);
        int[] minStartTime = new int[n];
        int[] minEndTime = new int[n];
        for(int i=0;i<n;i++){
            int minStart= Integer.MAX_VALUE;
            int minEnd= Integer.MAX_VALUE;
            int minStartIndex = -1;
            int minEndIndex = -1;
            int index = x>=y?x:y;
            for(int j=0;j<index;j++){
                if(j<x && minStart>(contest[i][0]-v[j]) && contest[i][0]>=v[j]){
                    minStart=contest[i][0]-v[j];
                    minStartIndex=j;
                }
                if(j<y && minEnd>(w[j]-contest[i][1]) && w[j]>=contest[i][1]){
                    minEnd=w[j]-contest[i][1];
                    minEndIndex=j;
                }
                if(minStart>-1 && minEnd>-1)
                    break;
            }
            time=Math.min(time,(minEnd-minStart+1));
        }
        int minTime = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(minEndTime[i]==0 || minStartTime[i]==0)
                continue;
            minTime  = Math.min(minTime,(w[minEndTime[i]-1]-v[minStartTime[i]-1])+1);
        }
        System.out.println(minTime);
    }
}
