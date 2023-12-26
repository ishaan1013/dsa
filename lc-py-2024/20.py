class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 1:
            return False

        stack = []
        brackets = {
            ")": "(",
            "}": "{",
            "]": "["
        }
        for c in s:
            if c in "([{":
                stack.append(c)
            else:
                if stack[-1] != brackets[c]:
                    return False
                stack.pop()
        return len(stack) == 0
