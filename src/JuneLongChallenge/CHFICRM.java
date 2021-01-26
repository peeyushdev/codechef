package JuneLongChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CHFICRM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] cash = new int[n];
            for (int i = 0; i < n; i++) {
                cash[i] = sc.nextInt();
            }
            Map<Integer, Integer> coinMap = new HashMap<Integer, Integer>();
            coinMap.put(5, 0);
            coinMap.put(10, 0);
            coinMap.put(15, 0);
            int cashInHand = 0;
            boolean isPossible = true;
            for(int i=0;i<n;i++){
                if(cash[i]==5){
                    cashInHand+=5;
                    coinMap.put(5,coinMap.get(cash[i])+1);
                    continue;
                }
                else{
                    if(cashInHand < cash[i]-5){
                        isPossible = false;
                        break;
                    }
                    else{
                        if(cash[i]==10){
                            if(coinMap.get(5)>0){
                                coinMap.put(5,coinMap.get(5)-1);
                                coinMap.put(10,coinMap.get(10)+1);
                                cashInHand+=5;
                                continue;
                            }
                            else{
                                isPossible = false;
                                break;
                            }
                        }
                        else if(cash[i]==15){
                            coinMap.put(15,coinMap.get(15)+1);
                            if(coinMap.get(10)>0){
                                cashInHand+=5;
                                coinMap.put(10,coinMap.get(10)-1);
                                continue;
                            }
                            if(coinMap.get(5)>1){
                                cashInHand+=5;
                                coinMap.put(5,coinMap.get(5)-2);
                                continue;
                            }
                            else{
                                isPossible = false;
                                break;
                            }
                        }
                    }
                }
            }
            if(isPossible)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
