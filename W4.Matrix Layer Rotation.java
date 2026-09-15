import java.util.*;
public class Solution {
    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;
        int layers = Math.min(m, n) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;
            // Store elements of the layer
            ArrayList<Integer> list = new ArrayList<>();
            // Top row
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                list.add(matrix[bottom][j]);
            }
            // Left column
            for (int i = bottom - 1; i > top; i--) {
                list.add(matrix[i][left]);
            }
            int size = list.size();
            // Anti-clockwise rotation
            int shift = r % size;
            // Put rotated values back
            int index = shift;
            // Top row
            for (int j = left; j <= right; j++) {
                matrix[top][j] = list.get(index);
                index = (index + 1) % size;
            }
            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = list.get(index);
                index = (index + 1) % size;
            }
            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix[bottom][j] = list.get(index);
                index = (index + 1) % size;
            }
            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = list.get(index);
                index = (index + 1) % size;
            }
        }
        // Print matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        matrixRotation(matrix, r);
        sc.close();
    }
}

