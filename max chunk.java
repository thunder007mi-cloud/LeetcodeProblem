class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] minRight = new int[n];
        
        // Step 1: Precompute the minimum values from right to left
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        }
        
        int chunks = 0;
        int maxLeft = Integer.MIN_VALUE;
        
        // Step 2: Iterate left to right and find valid partition points
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);
            // If maximum on left is <= minimum on right, a chunk can end here
            if (maxLeft <= minRight[i + 1]) {
                chunks++;
            }
        }
        
        // The remaining elements from the last split point to the end form the final chunk
        return chunks + 1;
    }
}
