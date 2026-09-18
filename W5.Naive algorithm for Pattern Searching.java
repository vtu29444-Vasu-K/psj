import java.util.Scanner;
public class Main {  
    static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        if (m > n) {
            return;
        }
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String text = sc.next();
            if (sc.hasNext()) {
                String pattern = sc.next();
                search(text, pattern);
            } else {
                System.out.println("Error: Pattern is missing.");
            }
        } else {
            System.out.println("Error: No input provided.");
        }     
        sc.close();
    }
}
