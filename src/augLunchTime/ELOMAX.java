package augLunchTime;

import java.util.Scanner;

public class ELOMAX {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] rating =  new int[n][m];
            int[] initialRating = new int[n];
            for(int i=0;i<n;i++)
                initialRating[i]=sc.nextInt();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int currentRate = sc.nextInt();
                    if(j==0){
                        rating[i][j]=initialRating[i]+currentRate;
                    }
                    else{
                        rating[i][j]=rating[i][j-1]+currentRate;
                    }
                }
            }
        }
    }
}
