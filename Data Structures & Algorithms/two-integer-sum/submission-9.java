class Solution {
    public int[] twoSum(int[] nums, int target) {
                
        if (nums.length < 2 || nums.length > 1000) return null;

        Map<Integer, Integer> numIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (numIndex.containsKey(difference)) {
                return new int[]{numIndex.get(difference), i};
            } 
            numIndex.put(nums[i], i);
        }
        return new int[]{};
    }
}
