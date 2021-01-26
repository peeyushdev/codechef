package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ZCO12002B {
    public static void main(String[] args) throws IOException {
        ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int x = Integer.parseInt(line1.split(" ")[1]);
        int y = Integer.parseInt(line1.split(" ")[2]);
        TreeMap<Integer, List<Contest>> contestInterval = new TreeMap<>();
        TreeMap<Integer, List<Contest>> warmholeInterval = new TreeMap<>();
//        int[][] contest = new int[n][2];
        for (int i = 0; i < n; i++) {
            line1 = br.readLine();
            Contest contest = new Contest(Integer.parseInt(line1.split(" ")[0]), Integer.parseInt(line1.split(" ")[1]));
            int interval = contest.getEndTime() - contest.getStartTime();
            List<Contest> contestList = new ArrayList<>();
            if (contestInterval.containsKey(interval)) {
                contestList = contestInterval.get(interval);
            }
            contestList.add(contest);
            contestInterval.put(interval, contestList);
        }
        int[] v = new int[x];
        int[] w = new int[y];
        line1 = br.readLine();
        for (int i = 0; i < x; i++) {
            v[i] = Integer.parseInt(line1.split(" ")[i]);
        }
        line1 = br.readLine();
        for (int i = 0; i < y; i++) {
            w[i] = Integer.parseInt(line1.split(" ")[i]);
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Contest contest = new Contest(v[i], w[j]);
                List<Contest> contestList = new ArrayList<>();
                int interval = contest.getEndTime() - contest.getStartTime();
                if (interval < 0)
                    continue;
                if (warmholeInterval.containsKey(interval)) {
                    contestList = warmholeInterval.get(interval);
                }
                contestList.add(contest);
                warmholeInterval.put(interval, contestList);
            }
        }
        int minInterval = -1;
        for (Map.Entry<Integer, List<Contest>> entry : warmholeInterval.entrySet()) {
            boolean found = false;
            List<Contest> contestList = entry.getValue();
            int warmHoleInterval = entry.getKey();
            for (Contest contest : contestList) {
                found = false;
                for (Map.Entry<Integer, List<Contest>> entry1 : contestInterval.entrySet()) {
                    int interval = entry1.getKey();
                    if (!(warmHoleInterval >= interval)) {
                        continue;
                    } else {
                        List<Contest> contest1 = entry1.getValue();
                        for (Contest contest2 : contest1) {
                            if (contest.getStartTime() <= contest2.getStartTime() && contest.getEndTime() >= contest2.getEndTime()) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                if (found) {
                    minInterval = warmHoleInterval + 1;
                    break;
                }
            }
            if (found)
                break;
        }
        System.out.println(minInterval);


    }
}

class Contest {
    private int startTime;
    private int endTime;

    public Contest(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}