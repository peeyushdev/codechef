package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZCO12002D {

    public static int getEntry(int[] time,int key){
        int start = 0;
        int end = time.length-1;
        int mid ;
        while(start<=end){
            mid = (end+start)/2;
            if(time[mid]==key)
                return mid;
            else if(time[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        return end;
    }
    public static int getExit(int[] time,int key){
        int start = 0;
        int end = time.length-1;
        int mid;
        while(start<=end){
            mid = (end+start)/2;
            if(time[mid]==key)
                return mid;
            else if(time[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int x = Integer.parseInt(line1.split(" ")[1]);
        int y = Integer.parseInt(line1.split(" ")[2]);
        String[] line2 = br.readLine().split(" ");
        int[][] contest = new int[n][2];
        for (int i = 0; i < n; i++) {
            contest[i][0] = Integer.parseInt(line2[0]);
            contest[i][1] = Integer.parseInt(line2[1]);
        }
        String[] vString = br.readLine().split(" ");
        int[] v = new int[x];
        int[] w = new int[y];
        for (int i = 0; i < x; i++) {
            v[i] = Integer.parseInt(vString[i]);
        }
        vString = br.readLine().split(" ");
        for (int i = 0; i < y; i++) {
            w[i] = Integer.parseInt(vString[i]);
        }
        Arrays.sort(v);
        Arrays.sort(w);
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t1 = getEntry(v,contest[i][0]);
            int t2 = getExit(w,contest[i][1]);
            if(t2==w.length || t1<0)
                continue;
            minTime = Math.min(minTime,(w[t2]-v[t1]+1));
        }
        System.out.println(minTime);
    }
}
