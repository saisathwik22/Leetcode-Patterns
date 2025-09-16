// leetcode 6

class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(s == null || s.isEmpty() || numRows <= 0) {
            return " ";
        }
        if(numRows == 1) {
            return s;
        }

        // step = 2 * k - 2;
        // for middle/diagonal elements = j + step - 2 * i

        StringBuilder ans = new StringBuilder();
        int step = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < n; j += step) {
                ans.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && (j + step - 2 * i) < n) {
                    ans.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        return ans.toString();
    }
}
