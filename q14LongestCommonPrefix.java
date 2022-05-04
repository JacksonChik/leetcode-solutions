class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        int shortestLen = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            shortestLen = shortestLen > strs[i].length() ? strs[i].length() : shortestLen;
        }
        for(int i = 0; i < shortestLen; i++){
            char curChar = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i) != curChar) return sb.toString();
            }
            sb.append(curChar);      
        }
        return sb.toString();
    }
}