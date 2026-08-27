import java.io.*;
import java.util.*;
public class Solution {
   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            int d = scan.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                row.add(scan.nextInt());
            }
            lines.add(row);
        }
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            // Converting 1-based index to 0-based index
            int lineIndex = x - 1;
            int posIndex = y - 1;
            if (lineIndex < lines.size() && posIndex < lines.get(lineIndex).size()) {
                System.out.println(lines.get(lineIndex).get(posIndex));
            } else {
                System.out.println("ERROR!");
            }
        }
        scan.close();
    }
}
