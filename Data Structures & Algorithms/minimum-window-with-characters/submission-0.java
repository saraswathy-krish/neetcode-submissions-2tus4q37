class Solution {
    //Dynamic window substring probelm - we keep shrinking the window.
    public String minWindow(String s, String t) {
        if (t.length()> s.length()){
            return "";
        }

        Map<Character,Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        for(char c: t.toCharArray()){
            countT.merge(c,1,Integer::sum);
        }
    
        int need = countT.size();
        int have =0;
        int l =0;
        int minLength = Integer.MAX_VALUE;
        int[] res = {-1,-1};
        for(int r=0;r<s.length();r++){
            char right = s.charAt(r);
            window.merge(right,1, Integer::sum);

            if(countT.get(right) == window.get(right)){
                have+=1;
            }

            while(have == need){
                if((r-l+1) < minLength){
                    minLength = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char left = s.charAt(l);
                window.merge(left,1, (v1, v2) -> v1 - v2);
                if(countT.containsKey(left) && window.get(left)<countT.get(left)){
                    have-=1;
                }
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE? "": s.substring(res[0],res[1]+1);
    }
}
