class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // [1,2,2,3,3,3], k = 2
        // {(1,1), (2.2), (3,3)}
        // [1,2,3] --sort--> [1,2,3]
        //                      ---
        // O(n klogk) 
        // Map<Integer, Integer> numFreq = new HashMap<>();
        // for (int i: nums) {
        //     numFreq.put(i, numFreq.getOrDefault(i, 0) + 1);
        // }

        // List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numFreq.entrySet());
    
        // list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        
        // int[] finalArr = new int[k];
        // for (int i = 0; i < k; i++) {
        //     finalArr[i] = list.get(i).getKey();
        // }

        // return finalArr;

        // Quando si ha a che fare con problemi di questo tipo si può usare il bucket sorting
        // [1,2,2,3,3,3], k = 2
        // {(1,1), (2,2), (3,3)}
        // [0, 0, 0, 0, 0, 0, 0] -> Array di N elementi dove N = len(nums) + 1 (Indici che indicano le fruequenze)
        // Per ogni coppia, scrivo nell'array alla posizione i = value = frequenza, la chiave
        // Alla fine, scorro l'array risultante a partire dall'ultima posizione, e salvo in un
        // array i top k
        // Esempio
        // [0, 1, 2, 3, 4, 5, 6] <- Indici
        // [0, 1, 2, 3, 0, 0, 0] <- Valori
        // if(nums.length == k) return nums;
        // Map<Integer, Integer> numFreq = new HashMap<>();
        // for (int i : nums) {
        //     numFreq.put(i, numFreq.getOrDefault(i, 0) + 1);
        // }
        // numFreq = {(1, 1), (2, 2), (3, 3)}, k = 2
        // int[] freqArr = new int[nums.length + 1]; // freqArr = [0,0,0,0,0,0,0]
        // for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
        //     freqArr[entry.getValue()] = entry.getKey();
        // }
        // freqArr = [0, 1, 2, 3, 0, 0, 0], k = 2
        // int[] result = new int[k]; // result = [0, 0]
        // for (int i = nums.length; i > 0; i--) {
        //     if (freqArr[i] != 0) {
        //         result[--k] = freqArr[i];
        //     }
        //     if (k == 0) break;
        // } 
        // return result;

        // La soluzione precedente va quasi bene, ma presenta un bug logico, [1,1,2,2], k = 2
        // porterebbe ad un risultato sbagliato.
        // Bisognerebbe usare per l'array delle frequenze, un'array di liste di interi

        if (nums.length == k) return nums;

        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int n : nums) {
            numFreq.put(n, numFreq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            int value = entry.getValue();
            if(freq[value] == null) {
                freq[value] = new ArrayList<>();
            }
            freq[value].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            if (freq[i] != null) {
                for (int n : freq[i]) {
                    result[index++] = n;
                    if (index == k) return result;
                }
            }
        }
        return result;
    }
}
