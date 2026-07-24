public class Solution {
    public boolean isPalindrome(String s) {
        // Initialize left pointer at start and right pointer at the end
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Move left pointer forward if the current character is not alphanumeric
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } 
            // Move right pointer backward if the current character is not alphanumeric
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } 
            // Compare characters after converting them to lowercase
            else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Mismatch found, not a palindrome
            } 
            // Characters match, move both pointers inward
            else {
                left++;
                right--;
            }
        }
        
        return true; // All alphanumeric characters matched
    }
}
