class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = charCount.get(c);
            if (count == null) return false;
            count--;
            if (count == 0) { 
                charCount.remove(c);
            } else {
                charCount.put(c, count);
            }
        }

        return charCount.isEmpty();
    }
}
