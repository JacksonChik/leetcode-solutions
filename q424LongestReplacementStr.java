class Solution {
    public HashMap<Character, Integer> usedChar = new HashMap<Character, Integer>();
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxRepeat = 0;
        for(int i = 0, j = 0; j < s.length(); j ++){
            

			usedChar.put(s.charAt(j), usedChar.getOrDefault(s.charAt(j),0) + 1);
            
            maxRepeat = usedChar.get(s.charAt(j)) > maxRepeat ? usedChar.get(s.charAt(j)) : maxRepeat;
            
            if(j - i + 1 - maxRepeat > k) {
				usedChar.put(s.charAt(i), usedChar.get(s.charAt(i)) - 1);
				i++;
			}
            
            maxLen = j - i + 1 > maxLen ? j - i + 1 : maxLen;
        }
        return maxLen;
    }
    

}