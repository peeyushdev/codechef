package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LADDU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            int activities = Integer.parseInt(input.split(" ")[0]);
            String nationality = input.split(" ")[1];
            long ladduCount = 0L;
            for (int i = 1; i <= activities; i++) {
                String input1 = br.readLine();
                String activty = input1.split(" ")[0];
                if (activty.equals("CONTEST_WON")) {
                    ladduCount += 300;
                    ladduCount += Integer.parseInt(input1.split(" ")[1]) >= 20 ? 0 : 20 - Integer.parseInt(input1.split(" ")[1]);
                } else if (activty.equals("TOP_CONTRIBUTOR")) {
                    ladduCount += 300;
                } else if (activty.equals("BUG_FOUND")) {
                    ladduCount += Integer.parseInt(input1.split(" ")[1]);
                } else {
                    ladduCount+=50;
                }
            }
            if(nationality.equals("INDIAN")){
                System.out.println(ladduCount/200);
            }else{
                System.out.println(ladduCount/400);
            }
        }

    }
}
