package solution;

public class Problem_062 {
	class Solution {
	    public int uniquePaths(int m, int n) {
	        if(m <= 0 || n <= 0)
	            return 0;
	        if(m == 1 || n == 1)
	            return 1;
	        int[][] ans = new int[n][m];
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < m; j++){
	                if(i == 0 || j == 0){
	                    ans[i][j] = 1;
	                    continue;
	                }
	                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
	            }
	        }
	        return ans[n - 1][m - 1];
	    }
	}
}
