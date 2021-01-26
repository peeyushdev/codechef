package DSALearningSeries;

import java.util.Scanner;
import java.util.Stack;

public class CHFQUEUE3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] seniority = new int[n];
        for (int i = 0; i < n; i++) {
            seniority[i] = sc.nextInt();
        }
        long output = 1;
        Stack<Integer> stack = new Stack<>();
        int[] minSeniority = new int[n];
        for(int i=0;i<n;i++){
            if(stack.isEmpty() || seniority[stack.peek()]<=seniority[i]){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && seniority[stack.peek()]>seniority[i]){
                int index= stack.pop();
                minSeniority[index]=i;
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            if(minSeniority[i]==0)
                continue;
            output*=((minSeniority[i]-i+1)%1000000007);
            output%=1000000007;
        }
        System.out.println(output % 1000000007);
    }
}


/*
* 10 4
4 2 3 2 1 4 3 3 2 1*/