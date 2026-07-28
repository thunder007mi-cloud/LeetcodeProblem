class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        
        int index = 0; // pointer for result array
        
        for (int i = 0; i < n; i++) {
            result[index] = nums[i];       // take x_i
            index++;
            result[index] = nums[i + n];   // take y_i
            index++;
        }
        
        return result;
    }
}
