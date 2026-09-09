import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if (deque.size() == m) {
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }
                // If maxUnique reaches m, it cannot be higher
                if (maxUnique == m) {
                    break;
                }
                int first = deque.remove();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }

        System.out.println(maxUnique);
        in.close();
    }
}
