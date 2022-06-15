import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else if (!matching( st.peek() , ch)) {
                    return false;
                } else st.pop();
            }
        }
        return (st.empty());

    }

    public static boolean matching(char a , char b){
        return (a =='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}') ;
    }
}