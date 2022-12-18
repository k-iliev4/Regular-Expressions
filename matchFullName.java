//Write a Java Program to match full names from a list of names and print them on the console.
//Writing the Regular Expression
//First, write a regular expression to match a valid full name, according to these conditions:
// • A valid full name has the following characteristics:
// ◦ It consists of two words.
// ◦ Each word starts with a capital letter.
// ◦ After the first letter, it only contains lowercase letters afterward.
// ◦ Each of the two words should be at least two letters long.
// ◦ The two words are separated by a single space.


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.print(matcher.group()+ " ");
        }
    }
}
