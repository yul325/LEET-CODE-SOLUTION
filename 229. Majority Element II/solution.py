class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        times = (int)(len(nums) / 3)
        res = []
        dict = {}
        for i in nums:
            if i not in dict:
                dict[i] = 1
            else:
                dict[i] += 1
        
        for i in dict:
            if dict[i] > times:
                res.append(i)
        return res


inst = Solution()
res = inst.majorityElement([3, 2, 3])
print(res)