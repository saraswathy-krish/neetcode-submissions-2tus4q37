class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> anaMap = new HashMap<>();

        for(String str: strs){
           int[] count = new int[26];
           for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'a']+=1;
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
