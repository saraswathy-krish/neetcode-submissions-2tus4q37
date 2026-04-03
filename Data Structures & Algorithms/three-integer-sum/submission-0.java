class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int l=0,r=0;
        int sum =0;
        for(int i=0;i<nums.length-2;i++){

            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            l=i+1;
            r=nums.length-1;
            while(l<r){
              sum = nums[l] + nums[r] + nums[i];

              if(sum==0){
                result.add(Arrays.asList(nums[i],nums[l],nums[r]));

                while(l<r &&nums[l]==nums[l+1]){
                    l+=1;
                }

                while(r>l && nums[r]==nums[r-1]){
                    r-=1;
                }
              }
              if(sum >0){
                r-=1;
              }else{
                l+=1;
                
            }

            }



        }
     return result;
    }
}
