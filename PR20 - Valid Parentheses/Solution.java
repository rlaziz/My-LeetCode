class Solution {
    public boolean isValid(String s) {
        StringBuilder open = new StringBuilder();
        for (char c : s.toCharArray()){
            switch (c){
                case ')' -> {
                    if (open.length() < 1){
                        return false;
                    }
                    if (open.charAt(open.length() - 1) != '('){
                        return false;
                    }else {
                        open.deleteCharAt(open.length() - 1);
                    }
                }
                case '}' -> {
                    if (open.length() < 1){
                        return false;
                    }
                    if (open.charAt(open.length() - 1) != '{'){
                        return false;
                    }else {
                        open.deleteCharAt(open.length() - 1);
                    }
                }
                case ']' -> {
                    if (open.length() < 1){
                        return false;
                    }
                    if (open.charAt(open.length() - 1) != '['){
                        return false;
                    }else {
                        open.deleteCharAt(open.length() - 1);
                    }
                }
                default -> open.append(c);
            }
        }
        return open.length() == 0;
    }
}