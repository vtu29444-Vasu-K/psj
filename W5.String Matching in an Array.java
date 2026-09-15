import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<String> stringMatching(String[] words) {
        // Sort words by length in ascending order
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // Only check against words strictly longer than words[i]
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Found a valid parent word
                }
            }
        }
        return result;
    }
}
