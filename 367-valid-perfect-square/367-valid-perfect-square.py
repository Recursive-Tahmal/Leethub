class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        x = 1
        
        while x <= num:
            if (x*x) == num:
                return True
            elif (x*x) > num:
                return False
            x += 1