class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0){
            return 0;
        }

        long result = 0;
        int i = 0;
        int sign = 1;

        if (s.charAt(0) == '+' || s.charAt(0) == '-'){
            i++;
        }
        if (s.charAt(0) == '-'){
            sign = -1;
        }

        while (i < s.length()){
            char c = s.charAt(i);
            if (c < 48 || c > 57){
                break;
            }
            if (sign == 1){
                if (result > Integer.MAX_VALUE / 10){
                    return Integer.MAX_VALUE;
                }
            }else {
                if (-1 * result < Integer.MIN_VALUE / 10){
                    return Integer.MIN_VALUE;
                }
            }
            result *= 10;
            result += c - 48;
            i++;
        }
        result = result * sign;

        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}