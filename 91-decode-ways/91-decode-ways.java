class Solution {
    
    // Using 1-D dp array solution
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i+1];
                if (i<n-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')))
                    dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
    
//     // Memoized solution -- 94.83% faster
//     public int numDecodings(String s) {
//         Integer[] memo = new Integer[s.length() + 1];
//         return s.length()==0?0:numDecodings(0,s,memo);
//     }
    
//     private int numDecodings(int i, String s, Integer[] memo) {
//         if (i == s.length()) return 1;
//         if (s.charAt(i) == '0') return 0;
//         if (memo[i]!=null) return memo[i];
//         int ans = numDecodings(i+1, s, memo); // Considering single character -- decode rest of the string
//         if (i<s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')))
//             ans+= numDecodings(i+2, s, memo); // Decode rest of the string after 2 combined characters
//         memo[i] = ans;
//         return memo[i];
//     }
    
//     // Recursive solution - O(2^n) -- TLE
//     public int numDecodings(String s) {
//         return s.length()==0?0:numDecodings(0,s);
//     }
    
//     // Decode char alone or pair with 1 more character after it
//     private int numDecodings(int i, String s) {
//         if (i == s.length()) return 1;
//         if (s.charAt(i) == '0') return 0;
//         int ans = numDecodings(i+1, s);  // Considering single character -- decode rest of the string
//         if (i<s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')))
//             ans+= numDecodings(i+2, s); // Decode rest of the string after 2 combined characters
//         return ans;
//     }
}