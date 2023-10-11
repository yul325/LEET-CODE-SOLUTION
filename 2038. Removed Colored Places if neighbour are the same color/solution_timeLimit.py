class Solution(object):
    def winnerOfGame(self, colors):
        """
        :type colors: str
        :rtype: bool
        """
        curPlayer = 'A'
        while True:
            if len(colors) <= 2:
                if curPlayer == 'A':
                    return False
                else:
                    return True

            if curPlayer == 'A':
                for i, color in enumerate(colors):
                    if i == len(colors) - 2:
                        return False
                    if color == 'A' and colors[i+1] == 'A' and colors[i+2] == 'A':
                        colors = colors[:i+1] + colors[i+2:]
                        curPlayer = 'B'
                        break
            else:
                for i, color in enumerate(colors):
                    if i == len(colors) - 2:
                        return True
                    if color == 'B' and colors[i+1] == 'B' and colors[i+2] == 'B':
                        colors = colors[:i+1] + colors[i+2:]
                        curPlayer = 'A'
                        break


inst = Solution()
inst.winnerOfGame("AAABABB")

