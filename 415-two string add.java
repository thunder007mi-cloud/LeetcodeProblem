import java.util.Scanner;

// The exact class structure required by online judges (LeetCode, HackerRank, etc.)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
            
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}

// The Driver class that replicates how the platform runs your code
public class Main {
    public static void main(String[] args) {
        // Instantiate the solution class just like the online judge driver does
        Solution solver = new Solution();

        // Test Case 1
        String param_1 = "11";
        String param_2 = "123";
        String ret1 = solver.addStrings(param_1, param_2);
        System.out.println("Output 1: " + ret1); // Expected: 134

        // Test Case 2
        System.out.println("Output 2: " + solver.addStrings("456", "77")); // Expected: 533

        // Test Case 3
        System.out.println("Output 3: " + solver.addStrings("0", "0")); // Expected: 0
    }
}
