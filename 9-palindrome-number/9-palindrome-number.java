class Solution {
    public boolean isPalindrome(int x) {
    String nums = String.valueOf(x);

    for(int i = 0, j = nums.length() - 1; i < j; ++i, --j){
        if (nums.charAt(i) != nums.charAt(j)){
            return false;
        }
    }
        return true;
    }
}