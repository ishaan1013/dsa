class Solution:
    def isPalindrome(self, s: str) -> bool:
        new = ""

        for c in s:
            if c.isalnum():
                new += c.lower()

        res = new == new[::-1]
        return res
