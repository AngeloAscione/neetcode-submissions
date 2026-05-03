class Solution {
    public boolean isPalindrome(String s) {

        List<Character> charList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isAlphaNumeric(c)) {
                charList.add(Character.toLowerCase(c));
            }
        }

        int length = charList.size();
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
            if (charList.get(i) != charList.get(j)) {
                return false;
            }
        }

        return true;
    }

    public boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
