package juneCodeOff;

import java.util.Scanner;

public class CACHEHIT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++)
                arr[i] = sc.nextInt();
            int update = 1;
            int start = (arr[0]/b)*b;
            for(int i=1;i<m;i++){
                if(start<=arr[i] && start+b-1 >= arr[i])
                    continue;
                else{
                    update++;
                    start =  (arr[i]/b)*b;
                }
            }
            System.out.println(update);
        }
    }
}
