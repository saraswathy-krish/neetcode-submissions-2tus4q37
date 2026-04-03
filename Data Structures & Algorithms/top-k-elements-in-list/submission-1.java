//Bucket sort
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        //This is to handle the case where the nums array contains all of the same elements: Eg: [8,8,8,8,8] in this case we need an array with index=5
        List<Integer>[] freq = new List[nums.length+1];
        for (int num: nums){
            freqMap.merge(num,1,Integer::sum);
        }
        for (int i=0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }
        //Mapping the frequency count to the number (remember why we do this)
        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index=0;
        //This is just for production safety
        for(int i=freq.length-1;i>0;i--){
            for(int n: freq[i]){
                res[index++] = n;
                if(index==k){
                    return res;
                }
            }
        }
    return res;

    }
}
