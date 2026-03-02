import java.util.Scanner;

/**
 * UC: Ignore Spaces and Case while Checking Palindrome
 *
 * Goal:
 * Normalize string using regex
 * Then apply palindrome logic
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Checker - Ignore Spaces & Case =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Normalize string
        input = input.replaceAll("[^a-zA-Z0-9]", "")  // Remove special characters & spaces
                .toLowerCase();                  // Convert to lowercase

        int start = 0;
        int end = input.length() - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        scanner.close();
    }
}