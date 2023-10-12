from typing import List

class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        nFlower = len(flowers)
        nPeople = len(people)

        hash = {}
        for flower in flowers:
            start = flower[0]
            end = flower[1]
            for i in range(start, end+1):
                if i not in hash:
                    hash[i] = 1
                else:
                    hash[i] += 1
        
        res = []
        for person in people:
            count = 0
            if person in hash:
                count = hash[person]
            res.append(count)
        return res