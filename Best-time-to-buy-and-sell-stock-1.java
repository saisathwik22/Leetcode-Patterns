// Leetcode 121
// Brute force TLE

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        List<Integer> maxToRight = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int tempMax = -1;
            // find max element to right of every prices[i], if not assign prices[i] to it.
            for(int j = i + 1; j < n; j++) {
                tempMax = Math.max(tempMax, prices[j]);
            }
            maxToRight.add(Math.max(tempMax, prices[i]));
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max((maxToRight.get(i) - prices[i]), ans);
        }
        return ans;
    }
}

// Optimal Approach : DP
// TC : O(n) SC : O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int tempMin = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < n; i++) {
            int cost = prices[i] - tempMin;
            maxProfit = Math.max(maxProfit, cost);
            tempMin = Math.min(tempMin, prices[i]);
        }
        return maxProfit;
    }
}
