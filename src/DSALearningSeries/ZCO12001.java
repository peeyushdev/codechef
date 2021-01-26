package DSALearningSeries;

import java.util.Scanner;
import java.util.Stack;

public class ZCO12001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder expression = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            expression.append(sc.nextInt() == 1 ? '(' : ')');
        }
        int depth = 0;
        int depthIndex = -1;
        Stack<Character> bracketsStack = new Stack<>();
        int depthStartIndex = 0;
        int maxLength = 0;
        int sequenceIndex= 0;
        boolean isCalCulated = false;
        for (int i = 0; i < n; i++) {
            if (expression.charAt(i) == '(') {
                bracketsStack.push('(');
                isCalCulated = false;
            } else {
                if (!isCalCulated) {
                    isCalCulated = true;
                    if (depth < bracketsStack.size()) {
                        depth = bracketsStack.size();
                        depthIndex = i;
                    }
                }
                bracketsStack.pop();
            }
        }
        bracketsStack = null;
        bracketsStack = new Stack<>();
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            if(expression.charAt(i)=='('){
                bracketsStack.push('(');
                if(bracketsStack.size()==1){
                    startIndex=i;
                }
            }else{
                if(bracketsStack.size()==1){
                    if(maxLength<i-startIndex){
                        maxLength=(i-startIndex+1);
                        sequenceIndex=startIndex+1;
                    }
                }
                bracketsStack.pop();
            }
        }
        StringBuilder output = new StringBuilder();
        output.append(depth+" ");
        output.append(depthIndex+" ");
        output.append(maxLength+" ");
        output.append(sequenceIndex);
        System.out.println(output);
    }
}
