class Solution:
    def find132pattern (self, nums: list[int]) -> bool:
        n = len(nums)

        if n <= 2:
            return False

        for i in range(1, n - 1):
            if (nums[i] > nums[i + 1]) and (nums[i + 1] > nums[i - 1]):
                return True
            else:
                # max of right and min of left

                rightMax = -pow(10, 9)
                for right in range(i + 1, n): #right
                    if nums[right] >= nums[i]:
                        continue
                    else:
                        rightMax = max(rightMax, nums[right])
                for left in range(i):
                    if rightMax > nums[left]:
                        return True
                
        return False
    
inst = Solution()
inst.find132pattern([-2, 1, 1])