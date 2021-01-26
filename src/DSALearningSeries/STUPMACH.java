package DSALearningSeries;

import java.util.Scanner;

public class STUPMACH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] storage = new long[n];
            for(int i=0;i<n;i++)
                storage[i]=sc.nextLong();
            long tokens = 0L;
            long[] minArray = new long[n];
            minArray[1]=Math.min(storage[0],storage[1]);
            for(int i=2;i<n;i++){
                minArray[i]=Math.min(minArray[i-1],storage[i]);
            }
            long currentOperation = 1L;
            for(int i=n-1;i>0;i--){
                if(minArray[i]-currentOperation>0){
                    tokens+=(i+1)*(minArray[i]-currentOperation);
                    currentOperation+=minArray[i]-currentOperation;
                }
            }
            if(storage[0]-currentOperation>0){
                tokens+=(storage[0]-currentOperation);
            }
            System.out.println(tokens+n);
        }
    }
}



