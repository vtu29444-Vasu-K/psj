   class Solution {
    public ArrayList<ArrayList<Integer>> multiply(int[][] a, int[][] b) {
        // code here
     int n = a.length;
     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
     for(int i =0;i<n;i++){
         ArrayList<Integer> l = new ArrayList<>();
         ans.add(l);
         for(int j =0;j<n;j++){
             int sum = 0;
             for(int k=0;k<n;k++){
                 sum+=(a[i][k]*b[k][j]);
             }
             ans.get(i).add(sum);
         }
     }
     return ans;
    }
}
