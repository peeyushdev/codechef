package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SAVKONO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int z = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            TreeSet<Integer> powers = new TreeSet<>();
            PriorityQueue<Integer> powerQueue = new PriorityQueue<>((o1, o2) -> -(o1.compareTo(o2)));
            for (int i = 0; i < n; i++) {
                powers.add(Integer.parseInt(input[i]));
                powerQueue.add(Integer.parseInt(input[i]));
            }
            System.out.println(powerQueue);
            int minTurn = 0;
            while (z > 0 && powerQueue.peek() > 0) {
                z -= powerQueue.peek();
                int last = powerQueue.poll();
                last /= 2;
                powerQueue.add(last);
                minTurn++;
            }
            if (z < 0)
                System.out.println(minTurn);
            else System.out.println("Evacuate");
        }
    }
}
