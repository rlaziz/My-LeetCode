class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        int prev = -1;

        while (i < s.length()){
            int current = 0;

            switch(s.charAt(i)){
                case 'M' -> current = 1000;
                case 'D' -> current = 500;
                case 'C' -> current = 100;
                case 'L' -> current = 50;
                case 'X' -> current = 10;
                case 'V' -> current = 5;
                case 'I' -> current = 1;
            }

            if (prev == -1){
                result += current;
                prev = current;
                i++;
            }else {
                if (prev < current){
                    result -= prev;
                    result += current;
                    result -= prev;
                    i ++;
                    prev = -1;
                }else {
                    result += current;
                    prev = current;
                    i++;
                }
            }
        }

        return result;
    }

}