class Solution {
    public int firstUniqChar(String s) {
        char temp;
        for(int i = 0; i < s.length(); ++i){
            temp = s.charAt(i);
            if(s.indexOf(temp,i+1) == -1 & s.indexOf(temp) != -1 & s.indexOf(temp) == i) {
                    return i;
            }
        }
        return -1;
    }
}