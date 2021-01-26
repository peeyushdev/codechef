package GS;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution1 {

    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        Stack<PAIR> pairStack = new Stack<>();
        for(int i=0;i<inputArray.size();i++){
            if(pairStack.isEmpty()){
                PAIR pair = new PAIR();
                pair.setCharactor(inputArray.get(i));
                pair.setCount(1);
                pairStack.push(pair);
            }else{
                if(pairStack.peek().getCharactor().equals(inputArray.get(i))){
                    pairStack.peek().setCount(pairStack.peek().getCount()+1);
                }
                else{
                    if(pairStack.peek().getCount()>= burstLength){
                        pairStack.pop();
                    }
                    if(pairStack.isEmpty() || !pairStack.peek().getCharactor().equals(inputArray.get(i))) {
                        PAIR pair = new PAIR();
                        pair.setCharactor(inputArray.get(i));
                        pair.setCount(1);
                        pairStack.push(pair);
                    }else {
                        pairStack.peek().setCount(pairStack.peek().getCount()+1);
                    }
                }
            }
        }
        List<String> outputArray = new ArrayList<>();
        while(!pairStack.isEmpty()){
            long count = pairStack.peek().getCount();
            String charactor = pairStack.peek().getCharactor();
            while(count-- >0){
                outputArray.add(0,charactor);
            }
            pairStack.pop();
        }
        return outputArray;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> inputArray = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            inputArray.add(sc.next());
        }
        int burstLength = sc.nextInt();
        inputArray = getShrunkArray(inputArray, burstLength);
        System.out.println(inputArray);
    }
}

class PAIR{
    String charactor;
    long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getCharactor() {
        return charactor;
    }

    public void setCharactor(String charactor) {
        this.charactor = charactor;
    }
}
