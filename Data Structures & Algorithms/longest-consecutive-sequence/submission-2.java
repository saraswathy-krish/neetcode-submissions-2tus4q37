class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        if(nums.length ==0){
            return 0;
        }
        for (int n: nums){
           numSet.add(n);
        }
        
        int length =0;
        int maxLength =1;
        for(int i=0;i<nums.length;i++){
            length = 0;
            if(!numSet.contains(nums[i]-1)){
                //Finding the start of the sequence
                while(numSet.contains(nums[i] + length)){
                    length+=1;
                }

                maxLength = Math.max(length,maxLength);
            }
        }

        return maxLength;
    }
}
