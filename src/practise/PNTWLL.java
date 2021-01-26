package practise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class PNTWLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] height = new long[n];
            int[] color = new int[n];
            HashSet<Integer> uniqueColor = new HashSet<>();
            for (int i = 0; i < n; i++) {
                height[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                color[i] = sc.nextInt();
            }
            Stack<Integer>  paintStack = new Stack<>();
            for(int i=0;i<n;i++){
                if(paintStack.isEmpty()){
                    paintStack.push(i);
                    uniqueColor.clear();
                    uniqueColor.add(color[i]);
                }
                else{
                    if(height[paintStack.peek()]>height[i]){
                        if(!uniqueColor.contains(color[i])){
                            paintStack.push(i);
                        }else{
                            HashSet<Integer> colorToBeRemoved = new HashSet<>();
                            while(!paintStack.isEmpty() && height[paintStack.peek()]<=height[i]){
                                colorToBeRemoved.add(color[paintStack.peek()]);
                                paintStack.pop();
                            }
                            uniqueColor.removeAll(colorToBeRemoved);
                            if(!uniqueColor.contains(color[i])){
                                paintStack.push(i);
                            }
                        }
                    }else{
                        HashSet<Integer> colorToBeRemoved = new HashSet<>();
                        while(!paintStack.isEmpty() && height[paintStack.peek()]<=height[i]){
                            colorToBeRemoved.add(color[paintStack.peek()]);
                            paintStack.pop();
                        }
                        uniqueColor.removeAll(colorToBeRemoved);
                        paintStack.push(i);
                    }
                }
            }
            System.out.println(paintStack.size());
        }
    }
}
