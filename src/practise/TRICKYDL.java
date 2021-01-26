package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRICKYDL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long amountA = Long.parseLong(br.readLine());
            long maxProfit = 0L;
            long amountToBeGiven = 1L;
            long currentDay = 0L;
            long maxProfitDay = -1L;
            long totalAmountGot = 0L;
            long totalAmountGave = 0L;
            while (totalAmountGave<=totalAmountGot) {
                totalAmountGot+=amountA;
                totalAmountGave+=amountToBeGiven;
                if (maxProfit < totalAmountGot-totalAmountGave) {
                    maxProfit = totalAmountGot-totalAmountGave;
                    maxProfitDay = currentDay;
                }
                amountToBeGiven *= 2;
                currentDay++;
            }
            currentDay--;
            maxProfitDay++;
            System.out.println(currentDay+" " + maxProfitDay);
        }
    }
}
