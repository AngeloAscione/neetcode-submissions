class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // [-1,0,1,2,-1,-4] // Andrebbero usati i two pointers ma non ho idea di come
        // Mi viene in mente un'altra soluzione, che sfrutta alla base la soluzione di Two Sum, 
        // Creo una mappa aggiungendo chiave = numero e valore = indice.
        // Poi scorro sull'array e e per ogni coppia di numeri controllo se il valore a somma zero è presente nella mappa
        // Se si, se i,j,k hanno indici diversi, lo aggiungo alla lista di liste.

        // Map<Integer, Integer> hashMap = new HashMap<>();
        // Set<List<Integer>> result = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        //     hashMap.put(nums[i], i);
        // }

        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int kKey = (nums[i] + nums[j]) * -1;
        //         Integer kIndex = hashMap.get(kKey);
        //         if (kIndex != null && i != j && j != kIndex && i != kIndex) {
        //             List newList = new ArrayList<>(List.of(nums[i], nums[j], kKey));
        //             Collections.sort(newList);
        //             if(!result.contains(newList)) {
        //                 result.add(newList);
        //                 // System.out.println(newList);
        //             }
        //         }
        //     }
        // }

        // System.out.println(result);

        // La soluzione precedente è buona ma aggiunge troppa complessità su input grandi il tutto esplode, ordinamento array, calcolo hash ecc...
        // Quello che posso fare è puntare ad un solo ordinamento sull'array iniziale e poi provare un two pointers alla ricerca di un target che è dato dalla formuale
        // i + j + k = 0 --> j + k = -i

        // quindi effettuo una ricerca per ogni elemento nums[i]

        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) break; // Dato che è ordinato, non è più possibile ottenere da questo i in poi 0
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Non considero i duplicati
        
            int j = i + 1, k = nums.length - 1; // Inizio a cercare coppia da dopo i

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--; // Ci spostiamo a sinistra, prendiamo un numero più piccolo
                } else if (sum < 0) {
                    j++; // Ci spostiamo a destra, prendiamo un numero più grande
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }


        return result;
    }
}
