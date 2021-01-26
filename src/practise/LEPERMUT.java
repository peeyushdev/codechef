package practise;

import java.util.Scanner;

public class LEPERMUT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] permutation = new int[n];
            for(int i=0;i<n;i++)
                permutation[i]=sc.nextInt();
            long conversion = 0L;
            long localConversion = 0L;
            for(int i=1;i<n;i++){
                if(permutation[i]<permutation[i-1])
                    localConversion++;
            }
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(permutation[i]>permutation[j])
                        conversion++;
                }
            }
            if(conversion==localConversion)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
