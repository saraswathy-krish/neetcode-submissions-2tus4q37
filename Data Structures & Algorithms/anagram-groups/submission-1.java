class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> anaMap = new HashMap<>();

        for(String str: strs){
           int[] count = new int[26];
           //charArray is faster than charAt
           for(char c: str.toCharArray()) {
            count[c-'a']+=1;
           }
           StringBuilder sb = new StringBuilder();
           for(int num: count){
            sb.append('#');
            sb.append(num);
           }
            sb.append('#');

           String key = sb.toString();

           anaMap.computeIfAbsent(key,k->new ArrayList<String>()).add(str);
        }

        return new ArrayList<>(anaMap.values());
    }
}
