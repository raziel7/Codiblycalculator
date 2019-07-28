import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CodiblyCalculator {
    public static void main(String[] args) {

        Optional<Integer> calculated = calculate(args);

        calculated.ifPresentOrElse(c -> {
                    System.out.println("Calculation result:");
                    System.out.println(c);
                },
                () -> System.out.println("No parameters provided"));
    }


    private static Optional<Integer> calculate(String[] args) {
        List<Integer> values = new ArrayList<>();
        Optional<Integer> result = Optional.empty();

        for (String arg : args) {
            try {
                values.add(Integer.parseInt(arg));
            } catch (NumberFormatException e) {
                char operator = e.getMessage().charAt(19);

                switch (operator) {
                    case '+':
                        result = values.stream().reduce(Integer::sum);

                        validateAndConsumeResult(values, result);
                        break;

                    case '-':
                        result = values.stream().reduce((a, b) -> a - b);

                        validateAndConsumeResult(values, result);
                        break;

                    case '*':
                        result = values.stream().reduce((a, b) -> a * b);

                        validateAndConsumeResult(values, result);
                        break;

                    default:
                        result = Optional.empty();
                }
            }
        }

        return result;
    }

    private static void validateAndConsumeResult(List<Integer> values, Optional<Integer> result) {
        if (result.isPresent()) {
            values.removeAll(values);
            values.add(result.get());
        }
    }

    private static boolean chceckIfNumeric(String argument) {
        return argument.matches("-?\\\\d+(\\\\.\\\\d+)?");
    }
}
