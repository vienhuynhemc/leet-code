import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> characterInfo = new HashMap<>();
        for (char c : s.toCharArray()) {
            characterInfo.compute(c, (key, value) -> value == null ? 1 : value + 1);
        }

        StringBuilder resultBuilder = new StringBuilder();
        characterInfo.entrySet().stream().sorted(this::sortAccordingNumberOfPresent).forEach(entry -> resultBuilder.append(String.valueOf(entry.getKey()).repeat(entry.getValue())));

        return resultBuilder.toString();
    }

    private int sortAccordingNumberOfPresent(Entry<Character, Integer> entryOne, Entry<Character, Integer> entryTwo) {
        return entryTwo.getValue() - entryOne.getValue();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency handler = new SortCharactersByFrequency();
        System.out.println(handler.frequencySort("tree"));
        System.out.println(handler.frequencySort("cccaaa"));
        System.out.println(handler.frequencySort("Aabb"));
    }

}
