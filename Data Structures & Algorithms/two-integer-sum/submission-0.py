class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}

        for idx,num in enumerate(nums):
            rem = target - num
            if rem in num_map:
                return [num_map.get(rem),idx]
            else:
                num_map[num] = idx

        return [-1,-1]