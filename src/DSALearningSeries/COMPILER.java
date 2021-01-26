package DSALearningSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class COMPILER {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String expression = br.readLine();
            long prefixLength = 0;
            Stack<Character> characterStack = new Stack<>();
            if (expression.charAt(0) == '>')
                System.out.println(prefixLength);
            else {
                for (int i = 0; i < expression.length(); i++) {
                    if (!characterStack.empty()) {
                        if (characterStack.peek() == expression.charAt(i))
                            characterStack.push(expression.charAt(i));
                        else {
                            characterStack.pop();
                            if (characterStack.empty()) {
                                prefixLength = i + 1;
                            }
                        }
                    } else {
                        if (expression.charAt(i) == '>') {
                            break;
                        }
                        characterStack.push(expression.charAt(i));
                    }
                }
                System.out.println(prefixLength);
            }
        }
    }
}
