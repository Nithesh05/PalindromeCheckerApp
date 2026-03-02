import java.util.Scanner;
import java.util.Stack;

/**
 * UC: Encapsulation Based Palindrome Validation
 *
 * Goal:
 * Encapsulate palindrome logic inside separate class.
 */

// Main class (Handles input/output only)
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Checker - OOP Version =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        scanner.close();
    }
}

// Separate class for logic (Encapsulation)
class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push characters
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Compare with pop
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}