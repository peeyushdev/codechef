package JuneLongChallenge;

import java.util.Scanner;

public class EVENM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder ans = new StringBuilder();
            int currentValue =1;
            for(int i=1;i<=n;i++){
                if(i%2!=0){
                    int j = currentValue;
                    int k=1;
                    while(k<=n){
                        ans.append(j+" ");
                        k++;
                        j++;
                    }
                    currentValue=j;
                    ans.append("\n");
                }
                else{
                    int j=currentValue+n-1;
                    int k=1;
                    while(k<=n){
                        ans.append(j+" ");
                        j--;
                        k++;
                    }
                    currentValue+=n;
                    ans.append("\n");
                }
            }
            System.out.println(ans);
        }
    }
}
