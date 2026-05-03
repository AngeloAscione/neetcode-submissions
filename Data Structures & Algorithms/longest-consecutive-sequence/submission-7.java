class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        
        // Creo una priority queue con tutti gli elementi all'interno
        // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // for (int i : nums) {
        //     minHeap.add(i);
        // }

        // int maxConsecutive = 1;
        // int running = 1;

        // while (minHeap.size() != 0) {
        //     Integer head = minHeap.poll();
        //     Integer newHead = minHeap.peek();

        //     if (newHead == null) break;
        //     if (newHead == head) continue;

        //     if (newHead - head == 1) { 
        //         running++;
        //         if (running > maxConsecutive) {
        //             maxConsecutive = running;
        //         }
        //     } else {
        //         running = 1;
        //     }
        // }

        // return maxConsecutive;

        // L'algoritmo precedente ha una complessità O(N log N);

        // Possiamo fare di meglio, se utilizzassi un HashSet, il costo di Aggiunta, Ricerca e Rimozione sarebbe O(1)

        Set<Integer> hashSet = new HashSet<>();

        for (int n : nums) {
            hashSet.add(n);
        }


        int maxConsecutive = 0;
        for (int n : nums) {
            if (!hashSet.contains(n - 1)) { // Inizio di una sequenza
                int running = 1;
                while(hashSet.contains(n + running)) {
                    running++;
                }
                maxConsecutive = Math.max(running, maxConsecutive);
            }
        }

        return maxConsecutive;
    }
}