class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)

        res = [1] * n

        for i in range(1,n):
            res[i] = nums[i-1] * res[i-1]

        ans = nums[n-1]
        for i in range(n-2,-1,-1):
            res[i] = res[i] * ans
            ans = ans * nums[i]

        return res