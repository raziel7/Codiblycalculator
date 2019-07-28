import java.util.Stack;

class StackCalculator {

    static Integer calculateByStack(String[] args) {
        Stack<Integer> numericStack = new Stack<>();

        for (String value : args) {
            if (checkIfNumeric(value)) {
                numericStack.push(Integer.parseInt(value));
            } else {
                if (numericStack.empty() || numericStack.size() == 1) {
                    return null;
                }

                Integer latter;
                Integer former;
                switch (value) {
                    case "+":
                        numericStack.push(numericStack.pop() + numericStack.pop());
                        break;

                    case "-":
                        latter = numericStack.pop();
                        former = numericStack.pop();
                        numericStack.push(former - latter);
                        break;

                    case "*":
                        numericStack.push(numericStack.pop() * numericStack.pop());
                        break;

                    //Pytanie czy chcemy, aby w przypadku podania dziwnych stringow, typu "qwe" w środku wyrażenia
                    //program wyrzucił wiadomość, że wyrażenie jest niepoprawne, czy po prostu pominął ten string i kontynuował?
                    default:
                        return null;
                }
            }
        }

        if (!numericStack.empty()) {
            return numericStack.pop();
        } else {
            return null;
        }
    }

    private static boolean checkIfNumeric(String argument) {
        return argument.matches("^[-]?\\d+$");
    }
}
