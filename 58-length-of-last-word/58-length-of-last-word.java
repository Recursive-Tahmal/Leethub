class Solution {
    public int lengthOfLastWord(String s) {
        int string = s.length() - 1;
        int count = 0;

        boolean found = false;
        while(string != -1) {
            char ch = s.charAt(string);
            if(found && ch == 32){
                break;
            }
            if(ch != 32){
                found = true;
                ++count;
            }
            --string;
        }
        return count;
    }
}