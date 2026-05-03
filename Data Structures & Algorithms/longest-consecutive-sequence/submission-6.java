class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        
        // Creo una priority queue con tutti gli elementi all'interno
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i : nums) {
            minHeap.add(i);
        }

        int maxConsecutive = 1;
        int running = 1;

        while (minHeap.size() != 0) {
            Integer head = minHeap.poll();
            Integer newHead = minHeap.peek();

            // System.out.println(minHeap + " head (removed): " + head + " newHead(notRemoved): " + newHead);

            if (newHead == null) break;
            if (newHead == head) continue;

            if (newHead - head == 1) { 
                running++;
                if (running > maxConsecutive) {
                    maxConsecutive = running;
                }
            } else {
                running = 1;
            }
        }

        return maxConsecutive;
        
    }
}