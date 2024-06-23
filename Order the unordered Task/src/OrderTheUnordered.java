import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderTheUnordered {

    public List<String> OrderUnordered(ArrayList<String> inputListOfStrings) {
        List<String> outputs = new ArrayList<>();


        for (String inputString : inputListOfStrings) {
            String regex1 = "[^a-zA-Z0-9]";
            String resultString = inputString.replaceAll(regex1, "");
//            System.out.println("Result string: "+ resultString);

            String regex2 = "[^0-9]";
            String numbersOnly = resultString.replaceAll(regex2, "");
//            System.out.println("Result of numbers only: "+ numbersOnly);

            String regex3 = "[0-9]";
            String charOnly = resultString.replaceAll(regex3, "");
//            System.out.println("Result of char only: "+ charOnly);

            List<Character> characters = charOnly.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());

//            System.out.println("Result of characters: "+ characters);
            List<Character> numbers = numbersOnly.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
//            System.out.println("Result of numbers: "+ numbers);

            // extract from list
            StringBuilder sbNum = new StringBuilder();
            for (Character numb : numbers) {
                sbNum.append(numb);
            }
            String numFinalResult = sbNum.toString();
            StringBuilder sbCh = new StringBuilder();
            for (Character character : characters) {
                sbCh.append(character);
            }
            String chFinalResult = sbCh.toString();
            outputs.add(numFinalResult + "\n" + chFinalResult);
        }
        return outputs;
    }
    public static void main(String[] args) {
        ArrayList<String> inputStrings = new ArrayList<>();
        inputStrings.add("5 % 8 R 1 = z");
        inputStrings.add("* + 4 - - , 5");
        inputStrings.add("8 W 5 * 2 _ A");
        inputStrings.add("4 _ 7 & _ 4 *");

        OrderTheUnordered OU = new OrderTheUnordered();
        List<String> finalOutput = OU.OrderUnordered(inputStrings);

        for (String output : finalOutput) {
            System.out.println(output);
        }
    }
}
