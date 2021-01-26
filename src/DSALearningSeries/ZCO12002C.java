package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZCO12002C {

    public static int getIndex(Set<Integer> time, int currentTime, boolean smaller) {
        int previousLength = time.size();
        time.add(currentTime);
        if (previousLength == time.size())
            return currentTime;
        int i = time.size() / 2;
        List<Integer> timeList = new ArrayList<>(time);
        Collections.sort(timeList);
        while (i >= 0 && i < time.size()) {
            if (timeList.get(i) == currentTime) {
                if (smaller)
                    return i > 0 ? timeList.get(i - 1) : -1;
                return i < timeList.size() - 1 ? timeList.get(i + 1) : -1;
            } else if (timeList.get(i) > currentTime) {
                i--;
            } else
                i++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int x = Integer.parseInt(line1.split(" ")[1]);
        int y = Integer.parseInt(line1.split(" ")[2]);
        int[][] contest = new int[n][2];
        for (int i = 0; i < n; i++) {
            line1 = br.readLine();
            contest[i][0] = Integer.parseInt(line1.split(" ")[0]);
            contest[i][1] = Integer.parseInt(line1.split(" ")[1]);
        }
        line1 = br.readLine();
        Set<Integer> v= new HashSet<>();
        Set<Integer> w= new HashSet<>();
        for (int i = 0; i < x; i++) {
            v.add(Integer.parseInt(line1.split(" ")[i]));
        }
        line1 = br.readLine();
        for (int i = 0; i < y; i++) {
            w.add(Integer.parseInt(line1.split(" ")[i]));
        }
        int minTime = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int startTime =  getIndex(v,contest[i][0],true);
            if(startTime==-1)
                continue;
            int endTime =  getIndex(w,contest[i][1],false);
            if(endTime==-1)
                continue;
            minTime= Math.min(minTime,endTime-startTime+1);
        }
        System.out.println(minTime);
    }
}
