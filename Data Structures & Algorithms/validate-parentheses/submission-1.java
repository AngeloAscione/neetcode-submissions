class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> parentheses = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (isOpenBracket(current)) {
                parentheses.push(current);
            } else if (isClosedBracket(current)) {
                if (parentheses.isEmpty())
                    return false;
                
                Character open = parentheses.pop();
                if (!matchParentheses(open, current)) {
                    return false;
                }
            } else {
                continue;
            }
        }

        return parentheses.isEmpty();
        
    }

    public boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    } 

    public boolean isClosedBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }


    public boolean matchParentheses(Character opened, Character closed) {
        return (opened == '(' && closed == ')') ||
                (opened == '[' && closed == ']') ||
                (opened == '{' && closed == '}');
    }
}
