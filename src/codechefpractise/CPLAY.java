package codechefpractise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPLAY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String streak = br.readLine();
        while (streak != null) {
            boolean isPrinted = false;
            int teamA = 0, teamB = 0;
            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    if (streak.charAt(i) == '1')
                        teamA++;
                } else {
                    if (streak.charAt(i) == '1')
                        teamB++;
                }
            }
            if (teamA == 3 && teamB == 0) {
                System.out.println("TEAM-A " + 6);
                isPrinted = true;
            } else if (teamB == 3 && teamA == 0) {
                System.out.println("TEAM-B " + 6);
                isPrinted = true;
            }
            int j = 6;
            if (!isPrinted) {
                if (streak.charAt(j) == '1')
                    teamA++;
                if (teamB - teamA > 1) {
                    System.out.println("TEAM-B " + 7);
                    isPrinted = true;
                }
                if(teamA-teamB > 2){
                    System.out.println("TEAM-A " + 7);
                    isPrinted = true;
                }
            }
            if (!isPrinted) {
                j++;
                if (streak.charAt(j) == '1')
                    teamB++;
                if (teamA - teamB > 1) {
                    System.out.println("TEAM-A " + 8);
                    isPrinted = true;
                }
                if (teamB - teamA > 1) {
                    System.out.println("TEAM-B " + 8);
                    isPrinted = true;
                }
            }
            if (!isPrinted) {
                j++;
                if (streak.charAt(j) == '1')
                    teamA++;
                if (teamB - teamA > 0) {
                    System.out.println("TEAM-B " + 9);
                    isPrinted = true;
                }
                if(teamA-teamB > 1){
                    System.out.println("TEAM-A " + 9);
                    isPrinted = true;
                }
            }
            if (!isPrinted) {
                j++;
                if (streak.charAt(j) == '1')
                    teamB++;
                if (teamA > teamB) {
                    System.out.println("TEAM-A " + 10);
                    isPrinted = true;
                }
                if (teamB  > teamA) {
                    System.out.println("TEAM-B " + 10);
                    isPrinted = true;
                }
            }
            if (!isPrinted) {
                for (int i = 10; i < 20; i++) {
                    if (streak.charAt(i) == '1')
                        teamA++;
                    i++;
                    if (streak.charAt(i) == '1')
                        teamB++;
                    if (teamA > teamB) {
                        j = i + 1;
                        System.out.println("TEAM-A " + j);
                        isPrinted = true;
                        break;
                    }
                    if (teamB > teamA) {
                        j = i + 1;
                        System.out.println("TEAM-B " + j);
                        isPrinted = true;
                        break;
                    }
                }
                if (!isPrinted)
                    System.out.println("TIE");
            }
            streak = br.readLine();
        }
        br.close();
    }
}