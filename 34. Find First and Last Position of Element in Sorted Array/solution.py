class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        res = []
        index = 0
        flag = False
        for i in nums:
            if i == target and flag == False:
                end = index
                res.append(index)
                flag = True
            elif i == target and flag == True:
                if index == (len(nums) - 1):
                    res.append(index)
            elif i != target and flag == True:
                res.append(index-1)
                break
                    
            index += 1
        if len(res) == 1:
            res.append(res[0])
        elif len(res) == 0:
            res.append(-1)
            res.append(-1)

        return res
    
inst = Solution()
inst.searchRange([1,2,3],1)
