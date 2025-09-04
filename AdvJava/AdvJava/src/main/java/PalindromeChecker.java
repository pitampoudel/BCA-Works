public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;
        str = str.toLowerCase().replaceAll("\\s+", "");
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tests = {"racecar", "hello", "A man a plan a canal Panama"};
        for (String test : tests) {
            System.out.println("'" + test + "' -> " + (isPalindrome(test) ? "Palindrome" : "Not Palindrome"));
        }
    }
}
