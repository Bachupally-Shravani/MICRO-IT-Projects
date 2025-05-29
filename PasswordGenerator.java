import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static String generatePassword(int length, boolean useUppercase, boolean useLowercase,
                                          boolean useDigits, boolean useSpecials) {

        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specials = "!@#$%^&*()-_=+<>?/{}[]|";

        StringBuilder characterPool = new StringBuilder();

        if (useUppercase) characterPool.append(uppercase);
        if (useLowercase) characterPool.append(lowercase);
        if (useDigits) characterPool.append(digits);
        if (useSpecials) characterPool.append(specials);

        if (characterPool.length() == 0) {
            return "Error: No character types selected.";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Generator ===");

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecials = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, useUppercase, useLowercase, useDigits, useSpecials);

        System.out.println("\nGenerated Password: " + password);
    }
}
