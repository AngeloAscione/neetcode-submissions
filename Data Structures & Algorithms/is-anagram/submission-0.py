class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        tableS = dict()
        tableT = dict()

        for i in range(len(s)):
            tableS[s[i]] = tableS.get(s[i], 0) + 1
            tableT[t[i]] = tableT.get(t[i], 0) + 1
            
        return tableS == tableT
        

        