class Solution {

    public String encode(List<String> strs) {
       if(strs==null || strs.size()==0){
        return "";
       }
       StringBuilder res = new StringBuilder();
       for(String s: strs){
        res.append(s.length()).append('#').append(s);
       }
      return res.toString();
    }

    public List<String> decode(String str) {
       List<String> result = new ArrayList<String>();
       int i=0;
       String num="";
       int length = 0;
       while (i<str.length()){
          num = "";
          while(str.charAt(i)!='#'){
            num = num + str.charAt(i);
            i+=1;
          }
         length = Integer.parseInt(num);
         result.add(str.substring(i+1,i+length+1));
         i+=length+1;
       }
       return result;
    }
}
