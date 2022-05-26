class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> parenthesesStack = new Stack<Character>();
        Stack<Integer> indexStack = new Stack<Integer>();

        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if(curChar != '(' && curChar != ')') continue;
            if(parenthesesStack.empty()) {
                parenthesesStack.push(curChar);
                indexStack.push(i);
                continue;
            }
            char curParentheses = parenthesesStack.peek().charValue();
            switch(curParentheses){
                case '(':
                    if(curChar == ')'){
                        parenthesesStack.pop();
                        indexStack.pop();
                    }
                    else{
                        parenthesesStack.push(curChar);
                        indexStack.push(i);
                    }
                    break;
                case ')':
                    parenthesesStack.push(curChar);
                    indexStack.push(i);
                    break;                
            }
        }
        
        StringBuilder resultSB = new StringBuilder(s);
        while(!indexStack.empty()) resultSB.deleteCharAt(indexStack.pop());
        return resultSB.toString();
    }
}