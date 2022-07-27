class Solution {
    public boolean isPerfectSquare(int x) {
        long num = 1;
        while (num <= x)
        {
            if (num * num == x) {
                return true;
            }
            else if (num * num > x) {
                return false;
            }

            ++num;
        }
        return false;
    }
}