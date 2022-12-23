//Let's take a break and visit the game bar. It is about time for the people behind the bar to go home, and you are the person who has to draw the line and calculate the money from the products that were sold throughout the day. Until you receive a line with the text "end of shift", you will be given lines of input. But before processing that line, you have to do some validations first.
//Each valid order should have a customer, product, count, and price:
//• Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters.
//• Valid product contains any word character and must be surrounded by '<' and '>'.
//• The valid count is an integer surrounded by '|'.
//• The valid price is any real number followed by '$'.
//The parts of a valid order should appear in the order given: customer, product, count, and price.
//For each valid line print on the console: "{customerName}: {product} - {totalPrice}"
//When you receive "end of shift", print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}".
//Input / Constraints
//• Strings must be processed until you receive the text "end of shift".
//Output
//• Print all the valid lines in the format "{customerName}: {product} - {totalPrice}".
//• After receiving "end of shift" print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}".
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class barIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%<(?<product>[A-Za-z]+)>\\|(?<quantity>\\d+)\\|(?<price>\\d+.+)\\$";

        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();

        double totalIncome = 0;

        while(!input.equals("end of shift")){

            Matcher matcher = pattern.matcher(input);

            boolean valid = matcher.find();

            if (valid){
                String name = matcher.group("name");
                String product = matcher.group("product");
                String quantity = matcher.group("quantity");
                String price = matcher.group("price");
                System.out.printf("%s: %s - %.2f\n",name,product,Integer.parseInt(quantity) * Double.parseDouble(price));
                totalIncome += Double.parseDouble(price) * Integer.parseInt(quantity);

            }else{
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalIncome);
    }
}
