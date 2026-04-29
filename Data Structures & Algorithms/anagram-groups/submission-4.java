class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }

        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String key = new String(sArr);
            List<String> anagrams = groupedAnagrams.getOrDefault(key, new ArrayList<>());
            anagrams.add(s);
            groupedAnagrams.put(key, anagrams);
        }
        
        return new ArrayList<>(groupedAnagrams.values());


    }

    public int getStringIntegerSum(String s) {
        char[] sArr = s.toCharArray();
        int sum = 0;
        for (char c : sArr) {
            sum += c;
        }
        return sum;
    }
}
