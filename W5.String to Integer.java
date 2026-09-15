public class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();  
        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }   
        if (i >= n) return 0;   
        // 2. Check for optional sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }       
        // 3. Process digits and handle overflow
        int total = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // Overflow Check prior to multiplication
            // Integer.MAX_VALUE / 10 is 214748364
            if (total > Integer.MAX_VALUE / 10 || 
               (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 
            total = total * 10 + digit;
            i++;
        } 
        return total * sign;
    }
}
