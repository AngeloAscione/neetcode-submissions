class Solution {
    public int[] getConcatenation(int[] nums) {
        if (nums.length < 1 || nums.length > 1000)
            return null;

        int[] concatenation = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > 1000) return null;
            concatenation[i] = nums[i];
            concatenation[i + nums.length] = nums[i];
        }

        return concatenation;
    }
}