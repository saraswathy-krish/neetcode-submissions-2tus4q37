class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int windowStart=0;
        int maxF = 0;
        int windowEnd =0;

        for(windowEnd =0;windowEnd<s.length();windowEnd++){
            maxF = Math.max(maxF,++count[s.charAt(windowEnd)-'A']);

            if((windowEnd - windowStart+1)-maxF > k){
                count[s.charAt(windowStart)-'A']-=1;
                windowStart+=1;
            }
        }

        return windowEnd - windowStart; //s.length()-windowStart;
    }
}
