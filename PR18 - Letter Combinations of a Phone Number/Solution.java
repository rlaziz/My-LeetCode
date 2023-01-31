class Solution {
    String[] map = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        accumulate(digits,0);
        return result;
    }
    void accumulate( String digits, int index){
        if (index >= digits.length()){
            result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        for (char c : this.map[digit - 50].toCharArray()){
            sb.append(c);
            accumulate(digits,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}