class Solution {
    //look at solution 3
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int windowEnd =0;
        int windowStart =0;
        char c = '\0';
        Set<Character> alphaSet = new HashSet<>();
        while(windowEnd < s.length()){
             c = s.charAt(windowEnd);
             while(alphaSet.contains(c)){
                alphaSet.remove(s.charAt(windowStart));
                windowStart+=1;
             }
             alphaSet.add(c);
             maxLength = Math.max(maxLength,windowEnd- windowStart+1);
             windowEnd+=1;
        }
        return maxLength;
    }
}
