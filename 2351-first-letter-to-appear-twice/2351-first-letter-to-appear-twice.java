class Solution {
    public char repeatedCharacter(String s) {
        char temp;
        int count = s.length()-1;
        for(int i = 0; i < s.length(); ++i){
            temp = s.charAt(i);
            if(s.indexOf(temp,i+1) != -1 & s.indexOf(temp,i+1) < count){
                count = s.indexOf(temp,i+1);
            }
        }
        return s.charAt(count);
    }
}