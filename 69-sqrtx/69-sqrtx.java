class Solution {
    public int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        int number = 0;
        for(int i = 0; i < x; ++i){
            if(((long) i * i) <= x){
                number = i;
            }
            else{
                break;
            }
        }

        return number;
    }
}