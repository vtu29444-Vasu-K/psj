import java.util.*;
interface PerformOperation {
    boolean check(int n);
}
public class Solution {
    public static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }
    public static PerformOperation isPrime() {
        return n -> {
            if (n < 2)
                return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        };
    }
    public static PerformOperation isPalindrome() {
        return n -> {
            int original = n;
            int reverse = 0;
            while (n > 0) {
                reverse = reverse * 10 + n % 10;
                n = n / 10;
            }
            return original == reverse;
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int condition = sc.nextInt();
            int number = sc.nextInt();
            PerformOperation op;
            if (condition == 1)
                op = isOdd();
            else if (condition == 2)
                op = isPrime();
            else
                op = isPalindrome();
            boolean result = op.check(number);
            if (condition == 1)
                System.out.println(result ? "ODD" : "EVEN");
            else if (condition == 2)
                System.out.println(result ? "PRIME" : "COMPOSITE");
            else
                System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
        }
        sc.close();
    }
}
