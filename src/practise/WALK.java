
package practise;
import java.util.Scanner;

class WALK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            int[] attractiveness = new int[n];
            for(int i=0;i<n;i++)
                attractiveness[i]=sc.nextInt();
            long minVelocity = attractiveness[0];
            long currentVelocity = minVelocity;
            for(int i=1;i<n;i++){
                --currentVelocity;
                if(currentVelocity>=attractiveness[i])
                    continue;
                currentVelocity=attractiveness[i];
                minVelocity=currentVelocity+i;
            }
            System.out.println(minVelocity);
        }
    }
}
