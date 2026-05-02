class Solution {

    // 271

    // Il problema chiede di creare un algoritmo di encoding e uno inverso di decoding

    // Per la funzione di encoding potremmo creare uno StringBuilder
    // Cliclare su ogni elemento della stringa, aggiungerlo allo stringBuilder e aggiungere un separatore
    // alla fine potrei aggiungere un terminatore per far capire che la stringa è terminata.
    // Potrei anche aggiungere una qualche tipo di metrica che mi indica la lunghezza della prola letta
    // Es. Hello -> _5_Hello -> _5_ è lo spacer che mi indica inizio parola + lunghezza 

    public String encode(List<String> strs) {

        if (strs.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append("_");
            sb.append(s.length());
            sb.append("_");
            sb.append(s);
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {

        if (str.isEmpty()) return new ArrayList<>();

        char[] decodedArr = str.toCharArray();
        if (decodedArr[0] != '_') return new ArrayList<>();
        
        List<String> decodedList = new ArrayList<>();
        StringBuilder wordLength;
        StringBuilder actualWord;

        for (int i = 0; i < decodedArr.length; i++) {
            wordLength = new StringBuilder();
            actualWord = new StringBuilder();
            int c = i + 1;
            while (decodedArr[c] != '_') {
                wordLength.append(decodedArr[c++]);
            }

            // _5_Hello, i = 0, c = 1
            //  c               c = 2
            // System.out.println(wordLength.toString() + " " + c);

            int intWordLength = Integer.parseInt(wordLength.toString());
            
            // c = 2, intWordLength = 5
            int j, k;
            // System.out.println(wordLength.toString() + " " + c + " " + intWordLength);

            for (j = c + 1, k = 0; k < intWordLength; k++, j++) {
                actualWord.append(decodedArr[j]);
            }

            // _5_Hello_5_World
            // System.out.println(actualWord.toString() + " " + j);

            i = j - 1; // i = 8
            
            decodedList.add(actualWord.toString());
        }

        // System.out.println(decodedList);
        return decodedList;
        
    }
}
