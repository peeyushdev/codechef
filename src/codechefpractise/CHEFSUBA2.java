package codechefpractise;

import java.util.Scanner;

class CHEFSUBA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        String request = sc.next();
        int totalShiftRequest = 0;
        for(int i=0;i<p;i++){
            if(request.charAt(i)=='!')
                totalShiftRequest++;
        }
        StringBuilder output = new StringBuilder();
        int[] maxOnes = new int[n];
        for (int l = 0; l <= totalShiftRequest%n; l++) {
            for (int i = 0; i < n; i++) {
                int ones = 0;
                for (int j = i; j < arr.length && j < k + i; j++) {
                    if (arr[j] == 1)
                        ones++;
                }
                if (maxOnes[l] < ones)
                    maxOnes[l] = ones;
            }
            int x = arr[0];
            for(int m=1;m<n;m++){
                int y = arr[m];
                arr[m]=x;
                x=y;
            }
            arr[0]=x;
        }
        int shiftRequest = 0;
        for(int i=0;i<request.length();i++){
            if(request.charAt(i)=='?'){
                output.append(maxOnes[shiftRequest%n]+"\n");
            }
            else
                shiftRequest++;
        }
        System.out.println(output);
    }
}