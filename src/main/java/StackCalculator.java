import java.util.Stack;

class StackCalculator {

    static Integer calculateByStack(String[] args) {
        Stack<Integer> numericStack = new Stack<>();
        Integer result = null;

        for (String value : args) {
            if (checkIfNumeric(value)) {
                numericStack.push(Integer.parseInt(value));
            } else {
                if (numericStack.empty() || numericStack.size() == 1) {
                    break;
                }

                Integer latter;
                Integer former;
                switch (value) {
                    case "+":
                        result = numericStack.pop() + numericStack.pop();
                        numericStack.push(result);
                        break;

                    case "-":
                        latter = numericStack.pop();
                        former = numericStack.pop();
                        result = former - latter;
                        numericStack.push(result);
                        break;

                    case "*":
                        result = numericStack.pop() * numericStack.pop();
                        numericStack.push(result);
                        break;

                    case "/":
                        latter = numericStack.pop();
                        former = numericStack.pop();
                        result = former / latter;
                        numericStack.push(result);
                        break;

                    //Pytanie czy chcemy, aby w przypadku podania dziwnych stringow, typu "qwe" w środku wyrażenia
                    //program wyrzucił wiadomość, że wyrażenie jest niepoprawne, czy po prostu pominął ten string i kontynuował?
                    default:
                        return null;
                }
            }
        }
        return result;
    }

    private static boolean checkIfNumeric(String argument) {
        return argument.matches("^[-]?\\d+$");
    }
}
