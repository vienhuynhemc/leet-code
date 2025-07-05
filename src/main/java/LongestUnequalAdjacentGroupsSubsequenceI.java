package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        final List<String> result = new ArrayList<>();

        int currentGroup = groups[0];
        result.add(words[0]);

        int i = 1;
        while (i < groups.length) {
            if (groups[i] == currentGroup) {
                i++;
                continue;
            }

            currentGroup = groups[i];
            result.add(words[i]);
            i++;
        }

        return result;
    }

}
