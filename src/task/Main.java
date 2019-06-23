package task;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String stringInput = "";
        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            if (scanner.hasNextLine()) {
                stringInput = scanner.nextLine();
            }
        }
        Pattern.compile("[^a-zа-я0-9]+")
                .splitAsStream(stringInput.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }
}
