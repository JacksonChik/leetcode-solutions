class Solution {
    public int lengthOfLongestSubstring(String s) {
    int rightPtr = 0;
    int leftPtr = 0;
    int globalMax = 0;
    Map<Character,Integer> charLastIndex = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            Character currentCharacter = new Character(s.charAt(i));
            if(charLastIndex.containsKey(currentCharacter)){
                rightPtr = i;
                leftPtr = charLastIndex.get(currentCharacter);
                
                charLastIndex.clear(); 
                
                for(int j = leftPtr; j <= rightPtr; j++){
                    charLastIndex.put(Character.valueOf(s.charAt(j)), j);
                }

                continue;
            }
        charLastIndex.put(currentCharacter, i);
        rightPtr++;
        globalMax = (rightPtr - leftPtr) > globalMax ? rightPtr - leftPtr : globalMax;
        }
    return globalMax;
    }
}