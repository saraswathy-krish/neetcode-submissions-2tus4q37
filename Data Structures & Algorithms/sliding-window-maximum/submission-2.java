class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> q = new ArrayDeque<>();

        int l=0,r=0;
        int n = nums.length;
        int[] output = new int[n-k+1];
        
       for(r=0;r<nums.length;r++){
          while(!q.isEmpty() && nums[q.getLast()] < nums[r] ){
             q.removeLast();
          }
          q.addLast(r);
          
          if(l>q.getFirst()){
            q.removeFirst();
          }

          if((r-l+1)>=k){
            output[l] = nums[q.getFirst()];
            l+=1; 
          }
       }

       return output;
    }
}
