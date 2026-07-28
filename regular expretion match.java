import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // memo[i][j] stores 1 for true, 0 for false, and -1 for unvisited
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dp(0, 0, s, p, memo);
    }
    
    private boolean dp(int i, int j, String s, String p, int[][] memo) {
        // Base case: if pattern is exhausted, text must also be exhausted
        if (j == p.length()) {
            return i == s.length();
        }
        
        // Return cached result
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        
        // Check if current characters match
        boolean firstMatch = (i < s.length() && 
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
        
        boolean ans;
        // Handle the '*' wildcard logic
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Choice 1: Skip '*' rule (0 occurrences)
            // Choice 2: Use '*' rule (match 1 character and stay on the pattern)
            ans = dp(i, j + 2, s, p, memo) || (firstMatch && dp(i + 1, j, s, p, memo));
        } else {
            // No wildcard, move both pointers forward
            ans = firstMatch && dp(i + 1, j + 1, s, p, memo);
        }
        
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
