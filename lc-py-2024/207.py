class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if not prerequisites:
            return False

        hm = {}

        for prereq in prerequisites:
            if not prereq[0] in hm:
                hm[prereq[0]] = set()
            hm[prereq[0]].add(prereq[1])

        visited = set()

        def dfs(key):
            # only not possible if a loop exists, need to check this for each starting value

            if key not in hm:
                return True
            if key in visited:
                return False

            visited.add(key)
            for next in hm[key]:
                if not dfs(next):
                    return False

            hm.pop(key)
            visited.remove(key)

            return True
        
        for course in prerequisites:
            if not dfs(course[0]):
                return False
            
        return True

