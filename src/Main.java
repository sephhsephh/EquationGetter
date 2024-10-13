import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        char[] equation = getInput();
        System.out.println("Valid equation entered: " + String.valueOf(equation));
    }

    static char[] getInput() {
        Scanner s = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("Enter an equation. Spaces are allowed, but will be ignored:");
            System.out.print("==>   ");
            input = s.nextLine();
            
            // Remove whitespaces before validation
            String cleanedInput = input.replaceAll("\\s+", "");

            if (!cleanedInput.isEmpty() && validateEquation(cleanedInput)) {
                return cleanedInput.toCharArray();  // Return the cleaned input (no spaces) as a character array.
            } else {
                System.out.println("Invalid input! Please enter only letters, digits, and operators (+, -, *, /, ^).");
            }
        }
    }

    static boolean validateEquation(String input) {
        // Check if the cleaned input contains only valid characters
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!Character.isLetterOrDigit(currentChar) && "+-*/^".indexOf(currentChar) == -1) {
                return false;  // Invalid character found.
            }
        }
        return true;  // All characters are valid.
    }
}
