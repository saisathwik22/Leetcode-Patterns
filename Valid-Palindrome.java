// leetcode 125
// TC : O(n)
class Solution {
    public boolean isAlphaNumeric(char ch) {
        if((ch >= '0' && ch <= '9') || (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z')) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        int start = 0, end = n - 1;
        while(start < end) {
            if(!isAlphaNumeric(s.charAt(start))) {
                start++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(end))) {
                end--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
