class Solution {
    public String toLowerCase(String s) {
        if (s == null) {
            return null;
        }
        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            // Check if character sits within the uppercase range
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Bitwise OR with 32 (or ' ') flips the 6th bit to 1,
                // which instantly converts uppercase to lowercase.
                chars[i] = (char) (chars[i] | 32);
            }
        }
        
        return new String(chars);
    }
}
