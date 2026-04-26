class Solution {
    public int[] twoSum(int[] nums, int target) {
                
        if (nums.length < 2 || nums.length > 1000) return null;

        HashMap<Integer, Integer> numIndex = new HashMap<>();
        int[] twoIndex = new int[]{0,0};

        for (int i = 0; i < nums.length; i++) {
            if (numIndex.containsKey(target - nums[i])) {
                twoIndex[0] = numIndex.get(target - nums[i]);
                twoIndex[1] = i;
                break;
            } else {
                numIndex.put(nums[i], i);
            }
        }

        return twoIndex;
    }
}
