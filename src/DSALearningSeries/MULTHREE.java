package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MULTHREE {

    public static long sumOfSeq(long k, long starting) {
        long sum = 0;
        sum += (20L * (k / 4L));
        if (k % 4L == 1)
            sum += starting;
        else if (k % 4L == 2)
            sum += starting + (starting * 2) % 10;
        else if (k % 4L == 3)
            sum += starting + ((starting * 2) % 10) + ((starting * 4) % 10);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            long k = Long.parseLong(input.split(" ")[0]);
            int firstDigit = Integer.parseInt(input.split(" ")[1]);
            int secondDigit = Integer.parseInt(input.split(" ")[2]);
            long sum = firstDigit + secondDigit;
            if (k > 2) {
                int thirdDigit = (firstDigit + secondDigit) % 10;
                sum += thirdDigit;
                if (thirdDigit == 1 || thirdDigit == 6) {
                    sum += sumOfSeq(k - 3L, 2L);
                } else if (thirdDigit == 2 || thirdDigit == 7) {
                    sum += sumOfSeq(k - 3L, 4L);
                } else if (thirdDigit == 3 || thirdDigit == 8) {
                    sum += sumOfSeq(k - 3L, 6L);
                } else if (thirdDigit == 4 || thirdDigit == 9) {
                    sum += sumOfSeq(k - 3L, 8L);
                }
            }
            System.out.println(sum);
            if (sum % 3L == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
//3801996921114

//                sum += thirdDigit;
//                sum += thirdDigit;
//                sum += thirdDigit;
//                sum += thirdDigit;
//            } else if (thirdDigit == 6) {
//                sum+=thirdDigit;
//                sum+=sumOfSeq(k-3,2);
//            } else if (thirdDigit == 7) {
//                sum+=thirdDigit;
//                sum+=sumOfSeq(k-3,4);
//            } else if (thirdDigit == 8) {
//                sum+=thirdDigit;
//                sum+=sumOfSeq(k-3,6);
//            } else if (thirdDigit == 9) {
//                sum+=thirdDigit;
//                sum+=sumOfSeq(k-3,8);
//            }