import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PipeAndFilter {

    public static void main(String[] args) {
        // Define the input list
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Create a pipeline of filters
        List<Function<List<Integer>, List<Integer>>> filters = new ArrayList<>();
        filters.add(PipeAndFilter::filterEvenNumbers);
        filters.add(PipeAndFilter::squareNumbers);
        filters.add(PipeAndFilter::addFiveToEachNumber);
        filters.add(PipeAndFilter::filterNumbersGreaterThanTen);

        // Process the input through the pipeline
        List<Integer> result = processPipeline(input, filters);

        // Output the final result
        System.out.println("Processed Output: " + result);
    }

    // Process the input through the pipeline of filters
    private static List<Integer> processPipeline(List<Integer> input, List<Function<List<Integer>, List<Integer>>> filters) {
        List<Integer> output = new ArrayList<>(input);
        for (Function<List<Integer>, List<Integer>> filter : filters) {
            output = filter.apply(output);
        }
        return output;
    }

    // Filter even numbers
    private static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Square each number
    private static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Add 5 to each number
    private static List<Integer> addFiveToEachNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n + 5)
                .collect(Collectors.toList());
    }

    // Filter numbers greater than 10
    private static List<Integer> filterNumbersGreaterThanTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
    }
}
