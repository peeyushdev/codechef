package JuneLongChallenge;

import java.io.IOException;
import java.util.Scanner;

public class TTUPLE {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(p==a && q==b && r==c)
                System.out.println(0);
            else if(p-a==q-b && q-b==r-c)
                System.out.println(1);
            else{
                if(a==0 || b ==0 ||c==0){
                    int change = a;
                    a=p;
                    p=change;
                    change = b;
                    b=q;
                    q=change;

                }
            }
        }
    }
}
