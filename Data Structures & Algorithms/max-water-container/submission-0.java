class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int area = 0;
        int n = heights.length-1;

        int l=0, r= n;

        while(l<r&& l< n && r>0){
          
          area = (r-l) * Math.min (heights[l],heights[r]);
          maxArea = Math.max(maxArea, area);

          if (heights[l] < heights[r]){
               l+=1;
          }else{
            r-=1;
          }

        }

        return maxArea;
    }
}
