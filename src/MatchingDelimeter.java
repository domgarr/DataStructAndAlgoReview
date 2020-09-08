public class MatchingDelimeter {
    public static boolean match(String s){
        Stack<Character> buffer = new LinkedStack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(isOpen(c)){
                buffer.push(c);
            }else{
                if(buffer.isEmpty()){
                    return false;
                }
                //Then is closing.
                char topChar = buffer.top();
                if(topChar == getOpenFromClosing(c)){
                    buffer.pop();
                }else{
                    return false;
                }
            }
        }

        return buffer.isEmpty();

    }

    private static boolean isOpen(char c){
        switch(c){
            case '[':
            case '(':
            case '{': return true;
            default: return false;
        }
    }

    private static char getOpenFromClosing(char c){
        switch(c){
            case ']': return '[';
            case '}': return '{';
            case ')': return '(';
            default: throw new IllegalArgumentException("The given does not have an opposite handled.");

        }
    }
}

