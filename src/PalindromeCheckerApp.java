import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * UC: Demonstrate FIFO vs LIFO using Queue and Stack
 *
 * Goal:
 * Compare dequeue (FIFO) and pop (LIFO)
 * to validate palindrome logic.
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        System.out.println("===== Palindrome Checker - FIFO vs LIFO =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        input = input.replaceAll("\\s+", "").toLowerCase();

        // Enqueue and Push characters
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);   // FIFO
            stack.push(ch);  // LIFO
        }

        boolean isPalindrome = true;

        // Compare dequeue vs pop
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
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