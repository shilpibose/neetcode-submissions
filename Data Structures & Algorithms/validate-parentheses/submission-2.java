class Solution {
    /**
        if open bracket
            push to stack
        if close bracket
            top should match corresponding open bracket,
                otherwise invalid input
        
        Once iteration complete, check if stack is empty, 
        if not return false

    **/
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                case '{':
                case '[':
                    deque.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if(deque.isEmpty()){
                        return false;
                    }
                    char open = deque.pop();
                    if(!isMatch(open, c)){
                        return false;
                    }

            }
        }

        return deque.isEmpty();
    }

    public boolean isMatch(char open, char close){
        return (open == '(' && close ==')') || (open == '{' && close =='}') || (open == '[' && close ==']');
    }
}
