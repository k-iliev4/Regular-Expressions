//Write a program that processes information about a race. On the first line, you will be given a list of participants separated by ", ". On the next few lines, until you receive the line "end of race" you will be given some info which will be some alphanumeric characters. In between them, you could have some extra characters which you should ignore. For example: "G!32e%o7r#32g$235@!2e". The letters are the name of the person, and the sum of the digits is the distance he ran. So here we have George, who ran 29 km. Store the information about the person only if the list of racers contains the name of the person. If you receive the same person more than once add the distance to his old distance. In the end, print the top 3 racers in the format:
//"1st place: {first racer}
//2nd place: {second racer}
//3rd place: {third racer}"

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameRegex = "[A-Za-z]+";
        String distanceRegex = "[\\d]{1}";
        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();

        for (String name:names) {
            racers.putIfAbsent(name,0);
        }

        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);
        String line = scanner.nextLine();
        while(!line.equals("end of race")){
            Matcher nameMatcher = namePattern.matcher(line);
            StringBuilder sb = new StringBuilder();
            while(nameMatcher.find()){
                sb.append(nameMatcher.group());
            }
            if (racers.containsKey(sb.toString())){
                Matcher distanceMatcher = distancePattern.matcher(line);
                int sum = 0;
                while(distanceMatcher.find()){
                    int digit = Integer.parseInt(distanceMatcher.group());
                    sum += digit;
                    racers.put(sb.toString(), racers.get(sb.toString()) + sum);
                }
            }

            line = scanner.nextLine();
        }
        List<String> sorted = racers.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        for (int i = 0; i < sorted.size(); i++) {
            if (i == 3){
                break;
            }
            System.out.printf("%dst place: %s%n",i+1,sorted.get(i));
        }
    }
}
