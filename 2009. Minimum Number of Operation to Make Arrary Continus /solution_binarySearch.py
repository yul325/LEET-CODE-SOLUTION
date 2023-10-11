import bisect

class Solution(object):
    def minOperations(self, nums):
        n = len(nums)
        ans = n
        nums = list(set(nums))
        nums.sort()

        min  = 0
        for left, element in enumerate(nums):
            right = left + n - 1
            j = bisect.bisect_right(nums, right)
            count = j - left
            ans = min(ans, count)
        return ans

           
