class Solution {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0){
            return false;
        }

        int l=0, r = s.length()-1;

        char[] str = s.toCharArray();

        while(l<r){

            while(l<r && !Character.isLetterOrDigit(str[l])){
                l++;
            }
            while(r>l && !Character.isLetterOrDigit(str[r])){
                r--;
            }

            if(Character.toLowerCase(str[l])!= Character.toLowerCase(str[r])){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
