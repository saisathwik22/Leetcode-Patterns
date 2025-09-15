// leetcode 392
// Approach 1
// Tc : O(m + n) SC : O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = t.length();
        int n = s.length();
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(t.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        if(j == n) return true;
        return false;
    }
}
// Approach 2 - Follow up
// TC : O(m*logn) SC : O(m)
class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mp.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        int prev = -1;
        for(char ch : s.toCharArray()) {
            if(!mp.containsKey(ch)) {
                return false;
            }
            List<Integer> indices = mp.get(ch);

            int index = Collections.binarySearch(indices, prev + 1);
            if(index < 0) {
                index = -index - 1;
            }
            if(index == indices.size()) {
                return false;
            }
            prev = indices.get(index);
        }
        return true;
    }
}
