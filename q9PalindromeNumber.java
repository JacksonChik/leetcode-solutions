class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String intStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder(intStr);
        return sb.reverse().toString().equals(intStr);        
    }
}