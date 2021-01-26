package augLongChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LINCHESS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input1 = br.readLine();
            int n = Integer.parseInt(input1.split(" ")[0]);
            int k = Integer.parseInt(input1.split(" ")[1]);
            input1 = br.readLine();
            String[] arr = input1.split(" ");
            int value = -1;
            for (int i = 0; i < n; i++) {
                int p1 = Integer.parseInt(arr[i]);
                if (k % p1 == 0) {
                    value = Math.max(value,p1);
                }
            }
            System.out.println(value);
        }
    }
}
