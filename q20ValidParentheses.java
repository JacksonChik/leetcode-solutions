import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack();
        for(int i = 0; i < s.length(); i++){
            if(bracketStack.empty()) {
                bracketStack.push(Character.valueOf(s.charAt(i)));
                continue;
            }
            if(bracketStack.peek().charValue() == '{' && s.charAt(i) == '}'){
                bracketStack.pop();
                continue;
            }
            if(bracketStack.peek().charValue() == '[' && s.charAt(i) == ']'){
                bracketStack.pop();
                continue;
            }
            if(bracketStack.peek().charValue() == '(' && s.charAt(i) == ')'){
                bracketStack.pop();
                continue;
            }
            else bracketStack.push(Character.valueOf(s.charAt(i)));
        }
        return bracketStack.empty();
    }
}