package DSALearningSeries;

import java.io.*;
import java.util.*;

public class ZCO12002E {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        List<PAIR> contestList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            contestList.add(new PAIR(sc.nextInt(), sc.nextInt()));
        }
        Set<Integer> vWarmHoles = new HashSet<>();
        Set<Integer> wWarmHoles = new HashSet<>();
        for (int i = 0; i < x; i++)
            vWarmHoles.add(sc.nextInt());
        for (int i = 0; i < y; i++)
            wWarmHoles.add(sc.nextInt());
        int minTime = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            PAIR contest = contestList.get(i);
            Set<Integer> startTime = new HashSet<>(vWarmHoles);
            Set<Integer> endTime = new HashSet<>(wWarmHoles);
            int previousSize = startTime.size();
            startTime.add(contest.getStartTime());
            int vStartTime = contest.getStartTime();
            if(previousSize!=startTime.size()){
                List<Integer> v = new ArrayList<>(startTime);
                Collections.sort(v);
                int index = Collections.binarySearch(v,contest.getStartTime());
                if(index>0)
                    vStartTime=v.get(index-1);
                else
                    vStartTime=-1;
            }
            if(vStartTime==-1)
                continue;
            previousSize = endTime.size();
            endTime.add(contest.getEndTime());
            int wEndTime = contest.getEndTime();
            if(previousSize!=endTime.size()){
                List<Integer> w = new ArrayList<>(endTime);
                Collections.sort(w);
                int index = Collections.binarySearch(w,contest.getEndTime());
                if(index<w.size()-1)
                    wEndTime= w.get(index+1);
                else
                    wEndTime=-1;
            }
            if(wEndTime==-1)
                continue;
            minTime = Math.min(minTime,(wEndTime-vStartTime+1));
        }
        System.out.println(minTime);
    }
}


class PAIR {
    int startTime;
    int endTime;

    public PAIR(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

}
