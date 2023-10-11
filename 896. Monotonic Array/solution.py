from typing import List
class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        n = len(nums)
        if n <= 2:
            return False
        
        if nums[0] > nums[-1]: #decreasing order
            for i in range(1, n):
                if nums[i] <= nums[i - 1]:
                    continue
                else:
                    return False
        else:
            for i in range(1, n): #increasing
                if nums[i] >= nums[i - 1]:
                    continue
                else:
                    return False
        return True
    
inst = Solution()
inst.isMonotonic([1, 1, 0])