class Solution {
    public boolean isPalindrome(String s) {

        // Funzionale ma non in-place, posso agire sulla stringa stessa e risparmiare spazio
        // List<Character> charList = new ArrayList<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (isAlphaNumeric(c)) {
        //         charList.add(Character.toLowerCase(c));
        //     }
        // }

        // int length = charList.size();
        // for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
        //     if (charList.get(i) != charList.get(j)) {
        //         return false;
        //     }
        // }

        // return true;


        int left = 0, right = s.length() - 1;
        while (left < right) {

            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++; // mi sposto a destra fin quando non trovo un carattere alpha numerico
            }

            while (right > left && !isAlphaNumeric(s.charAt(right))) {
                right--; // faccio la stessa cosa di sopra, mi sposto a sinistra alla ricerca di un carattere alpha numerico
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
