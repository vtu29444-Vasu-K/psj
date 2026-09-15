import java.io.*;
public class Solution {
    public static int[] maxSubarray(int[] arr) {
        // 1. Max Subarray Sum using Kadane's Algorithm
        int maxSubarray = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSubarray = Math.max(maxSubarray, currentSum);
        }
        // 2. Max Subsequence Sum
        int maxElement = arr[0];
        int positiveSum = 0;
        boolean hasPositive = false;
        for (int x : arr) {
            maxElement = Math.max(maxElement, x);
            if (x > 0) {
                positiveSum += x;
                hasPositive = true;
            }
        }
        int maxSubsequence = hasPositive ? positiveSum : maxElement;
        return new int[]{maxSubarray, maxSubsequence};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tInput = bufferedReader.readLine();
        if (tInput == null) return;
        int t = Integer.parseInt(tInput.trim());
        while (t-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());   
            // Regex "\\s+" safely splits across single or multiple spaces
            String[] arrTemp = bufferedReader.readLine().trim().split("\\s+");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(arrTemp[i]);
            }
            int[] result = maxSubarray(arr);
            System.out.println(result[0] + " " + result[1]);
        }
        bufferedReader.close();
    }
}
