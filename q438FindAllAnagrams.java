class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int[] charCount = new int[26];
        
        int sLen = s.length();
        int pLen = p.length();
        
        if(pLen > sLen) return result;
        
        for(int i = 0; i < pLen; i ++){
            charCount[p.charAt(i) - 'a']++;
            charCount[s.charAt(i) - 'a']--;
        }
        if(isAllZero(charCount)) result.add(0);
        
        for(int i = 0; i < sLen - pLen; i++){
            charCount[s.charAt(i + pLen) - 'a']--;
            charCount[s.charAt(i) - 'a']++;
            
            if(isAllZero(charCount)) result.add(i + 1);
        }
        
        return result;
    }
    
    private boolean isAllZero(int[] charCount){
        for(int i = 0; i < charCount.length; i ++){
            if(charCount[i] != 0) return false;
        }
        return true;
    }
}