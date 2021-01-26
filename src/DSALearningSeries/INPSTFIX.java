package DSALearningSeries;

import java.util.*;

public class INPSTFIX {
    public static void main(String[] args) {
        Map<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put(')', 1);
        priorityMap.put('^', 2);
        priorityMap.put('/', 3);
        priorityMap.put('*', 3);
        priorityMap.put('+', 4);
        priorityMap.put('-', 4);
        Set<Character> operatorSet = new HashSet<>();
        operatorSet.add('^');
        operatorSet.add('/');
        operatorSet.add('*');
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('(');
        operatorSet.add(')');
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String infixExpression = sc.next();
            Stack<String> operands = new Stack<>();
            Stack<Character> operators = new Stack<>();
            for (int i = 0; i < infixExpression.length(); i++) {
                char currentCharacter = infixExpression.charAt(i);
                if(!operatorSet.contains(currentCharacter)){
                    operands.push(String.valueOf(currentCharacter));
                    continue;
                }
                if(operators.isEmpty() || currentCharacter=='(' || operators.peek()=='('){
                    operators.push(currentCharacter);
                    continue;
                }
                if(currentCharacter==')'){
                    while (operators.peek()!='('){
                        String secondOperand = operands.pop();
                        String firstOperand = operands.pop();
                        char operator = operators.pop();
                        operands.push(firstOperand+secondOperand+operator);
                    }
                    operators.pop();
                    continue;
                }
                if(priorityMap.get(currentCharacter)>=priorityMap.get(operators.peek())) {
                    while (!operators.isEmpty() && operators.peek()!='(' && priorityMap.get(currentCharacter) >= priorityMap.get(operators.peek())) {
                        String secondOperand = operands.pop();
                        String firstOperand = operands.pop();
                        char operator = operators.pop();
                        operands.push(firstOperand + secondOperand + operator);
                    }
                    operators.push(currentCharacter);
                    continue;
                }
                operators.push(currentCharacter);
            }
            while(!operators.isEmpty()){
                String secondOperand = operands.pop();
                String firstOperand = operands.pop();
                char operator = operators.pop();
                operands.push(firstOperand+secondOperand+operator);
            }
            System.out.println(operands.pop());
        }
    }
}
