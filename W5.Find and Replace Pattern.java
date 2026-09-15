import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int[] patternSig = normalize(pattern);  
        for (String word : words) {
            if (Arrays.equals(patternSig, normalize(word))) {
                result.add(word);
            }
        }   
        return result;
    }
    // Normalizes a string to a structural signature array
    // e.g., "abb" and "mee" both become [0, 1, 1]
    private int[] normalize(String s) {
        int n = s.length();
        int[] sig = new int[n];
        int[] firstSeen = new int[26];
        Arrays.fill(firstSeen, -1);
        int id = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (firstSeen[c - 'a'] == -1) {
                firstSeen[c - 'a'] = id++;
            }
            sig[i] = firstSeen[c - 'a'];
        }  
        return sig;
    }
}
