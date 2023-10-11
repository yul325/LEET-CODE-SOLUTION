class Solution:
    def find132pattern (self, nums: list[int]) -> bool:
        n = len(nums)

        if n <= 2:
            return False
        
        stack = []
        stack.append(nums[0])
        stack.append(nums[0])
        for i in range(1, n):
            if nums[i] < stack[0]:
                stack.pop()
                stack.pop()
                stack.append(nums[i])
                stack.append(nums[i])
            elif nums[i] > stack[1]:
                stack.pop()
                stack.append(nums[i])
            elif nums[i] < stack[1] and nums[i] > stack[0]:
                return True
        return False

inst = Solution()
inst.find132pattern([3, 5, 0, 3, 4])