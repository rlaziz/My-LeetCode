class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> subString = new HashSet<>();
        int longest = 0;
        int first = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(subString.contains(c)){
                subString.remove(s.charAt(first));
                first++;
            }
            subString.add(c);
            longest = Math.max(longest,subString.size());
        }
        return longest;
    }
}