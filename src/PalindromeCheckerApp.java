import java.util.*;

/**
 * UC: Performance Comparison of Palindrome Algorithms
 *
 * Goal:
 * Compare execution time of different approaches.
 */

public class PalindromeCheckerApp {

    // Stack Based Method
    public static boolean stackMethod(String input) {

        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque Based Method
    public static boolean dequeMethod(String input) {

        Deque<Character> deque = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    // Two Pointer Method
    public static boolean twoPointerMethod(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Performance Comparison =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Stack Timing
        long startTime = System.nanoTime();
        boolean stackResult = stackMethod(input);
        long endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Deque Timing
        startTime = System.nanoTime();
        boolean dequeResult = dequeMethod(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        // Two Pointer Timing
        startTime = System.nanoTime();
        boolean pointerResult = twoPointerMethod(input);
        endTime = System.nanoTime();
        long pointerTime = endTime - startTime;

        System.out.println("\nResults:");
        System.out.println("Stack Method: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method: " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Two Pointer Method: " + pointerResult + " | Time: " + pointerTime + " ns");

        scanner.close();
    }
}