import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * UC: Deque Based Palindrome Validation
 *
 * Goal:
 * Use Deque to compare front and rear elements.
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new LinkedList<>();

        System.out.println("===== Palindrome Checker - Deque Based =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        input = input.replaceAll("\\s+", "").toLowerCase();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        scanner.close();
    }
}