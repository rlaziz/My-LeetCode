class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int copy = x;
        int reverse = 0;
        while (x > 0){
            reverse *= 10;
            reverse += x % 10;
            x /= 10;
        }
        return copy == reverse;
    }
}