package Map;

import Map.WordWrapper;

import java.util.*;

public class MapLauncher {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Please, enter your text: ");

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        String[] tokens = string.split(" ");
        for (String token : tokens) {
            String word = token.toLowerCase();
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, count = 1);
            } else {
                map.put(word, count + 1);
            }
        }

        printMap(convertToSet(map));
    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> map) {
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }
        return wordSet;
    }

    private static void printMap(NavigableSet<WordWrapper> wordSet) {
        for (WordWrapper keyword : wordSet) {
            System.out.printf("%-10s %-10s\n", keyword.getWord(), keyword.getCount());
        }
    }
}
