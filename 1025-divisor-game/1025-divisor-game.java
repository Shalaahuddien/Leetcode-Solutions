class Solution {
    // public boolean divisorGame(int n) {
    //     return n%2 == 0;
    // }
    
    // public boolean divisorGame(int n) {
    //     boolean dp[] = new boolean[n+1];
    //     dp[0] = false;
    //     dp[1] = false;
    //     for (int i=2; i<=n; i++) {
    //         for (int x=1; x<i; x++) { // Finding factors of n
    //             if (i%x==0) {
    //                 if (dp[i-x] == false) { // If bob loses on n-x then chose that x and set dp[i] as true
    //                     dp[i] = true;
    //                     break;
    //                 }
    //             }      
    //         }
    //     }
    //     return dp[n];
    // }
    
    
    Boolean dp[];
    public boolean divisorGame(int n) {
        if (n==0 || n==1) return false;
        dp = new Boolean[n+1];
        dp[0] = true; // n can never be 0 so set to true so that recursive call doesn't run
        dp[1] = false;
        boolean result = helper(n);
        return result;
    }
    
    private boolean helper(int n) {
        if (dp[n]!=null) return dp[n];
        dp[n] = false;
        for (int x=1; x*x<=n; x++) {
            if (n%x == 0) {
               if (!helper(n-x) || !helper(n - (n/x))) { // Found a way where Bob will lose so alice must choose that optimal way
                   dp[n] = true;
                   break;
               } 
            }
        }
        return dp[n];
    }
}