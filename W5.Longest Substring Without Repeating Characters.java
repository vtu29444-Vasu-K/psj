import java.util.HashMap;
import java.util.Map;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0; // Left pointer of the window
        Map<Character, Integer> charMap = new HashMap<>(); // Maps character to its last seen index
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // If the character was seen before and is inside the current window
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                left = charMap.get(currentChar) + 1; // Move left pointer past the duplicate
            }
            charMap.put(currentChar, right); // Update last seen position
            maxLength = Math.max(maxLength, right - left + 1); // Track maximum length
        }
        return maxLength;
    }
}
