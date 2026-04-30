class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // [1,2,2,3,3,3], k = 2
        // {(1,1), (2.2), (3,3)}
        // [1,2,3] --sort--> [1,2,3]
        //                      ---

        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int i: nums) {
            numFreq.put(i, numFreq.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numFreq.entrySet());
    
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        
        int[] finalArr = new int[k];
        for (int i = 0; i < k; i++) {
            finalArr[i] = list.get(i).getKey();
        }

        return finalArr;
    }
}
