class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] isJewel = new int[128];
        int jewelCount = 0;
        
        // Mark all character types that are jewels
        for (char j : jewels.toCharArray()) {
            isJewel[j] = 1;
        }
        
        // Count matching stones
        for (char s : stones.toCharArray()) {
            jewelCount += isJewel[s];
        }
        
        return jewelCount;
    }
}
