import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<furniture>[A-Z]\\w+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)";

        String input = scanner.nextLine();

        double totalPrice = 0.0;

        List<String> infoHolder = new ArrayList<>();

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                String priceString = matcher.group("price");
                String quantityString = matcher.group("quantity");

                double price = Double.parseDouble(priceString);
                int quantityInt = Integer.parseInt(quantityString);

                totalPrice += price * quantityInt;
                infoHolder.add(furniture);
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture: ");

        for (int i = 0; i < infoHolder.size(); i++) {
            System.out.println(infoHolder.get(i));
        }

        System.out.printf("Total money spent: %.2f", totalPrice);
    }
}
