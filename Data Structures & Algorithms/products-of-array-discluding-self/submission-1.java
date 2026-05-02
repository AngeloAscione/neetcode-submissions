class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // Creare un arry result con nums.length elementi.
        // Inizializzarlo con tutti 1
        // Poi scorrere il primo array e moltiplicare tutte le posizioni dell'array result per nums[i] tranne result[i]

        // es
        // nums = [1,2,4,6], // result = [1,1,1,1]
        // ciclo su nums
        // nums[i] = 1 -> nums[i] * result[i+1] ecc....

        // Time O(n2)

        // int[] result = new int[nums.length];
        // Arrays.fill(result, 1);
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < result.length; j++) {
        //         if (i != j) {
        //             result[j] *= nums[i];
        //         }
        //     }
        // }


        // int n = nums.length;
        // int[] result = new int[n]; 
        // int[] prefix = new int[n]; 
        // int[] suffix = new int[n]; 

        // prefix[0] = 1;
        // suffix[n - 1] = 1;
        // for (int i = 1; i < n; i++) {
        //     prefix[i] = nums[i - 1] * prefix[i - 1]; 
        // }

        // nums   = [1,2,4,6]
        // prefix = [1,1,2,8]

        // for (int i = n - 2; i >= 0; i--) {
        //     suffix[i] = nums[i + 1] * suffix[i + 1];
        // }

        // num    = [1,2,4,6]
        // suffix = [48,24,6,1]

        // for (int i = 0; i < n; i++) {
        //     result[i] = prefix[i] * suffix[i];
        // }

        // Possiamo ottimizzarlo fino ad O(1) spazio

        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i-1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;

    }
}  
