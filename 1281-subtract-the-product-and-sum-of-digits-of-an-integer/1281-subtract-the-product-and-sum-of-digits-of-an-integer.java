class Solution {
    public static int subtractProductAndSum(int n) {
        // write your code here
        int product = 1, sum = 0;
        String number = String.valueOf(n);
        for(int i = 0; i < number.length(); ++i){
        int temp = Integer.parseInt(String.valueOf(number.charAt(i)));
            sum += temp;
            product *= temp;
        }

        return product - sum;
    }
}