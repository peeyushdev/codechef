package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HP18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputFirstLine = br.readLine();
            long n = Long.parseLong(inputFirstLine.split(" ")[0]);
            long a = Long.parseLong(inputFirstLine.split(" ")[1]);
            long b = Long.parseLong(inputFirstLine.split(" ")[2]);
            long commonMultiple = 0;
            long multipleOfA = 0;
            long multipleOfB = 0;
            String[] inputSeq = br.readLine().split(" ");
            for (String input : inputSeq) {
                long inputNumber = Long.parseLong(input);
                if (inputNumber % a == 0 && inputNumber % b == 0) {
                    commonMultiple++;
                    continue;
                }
                if (inputNumber % a == 0) {
                    multipleOfA++;
                    continue;
                }
                if (inputNumber % b == 0) {
                    multipleOfB++;
                    continue;
                }
            }
            multipleOfA+=commonMultiple;
            if (multipleOfA > multipleOfB)
                System.out.println("BOB");
            else
                System.out.println("ALICE");
        }

    }
}
