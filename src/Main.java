import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print initial message to welcome the user
        System.out.println("Mortgage Calculator");

        // Ask the user to enter the length of their mortgage in years
        int years = 0;
        try {
            System.out.print("Enter the length of the mortage(in years): ");
            years = scanner.nextInt(); // Read the user's input for the length in years
        } catch (Exception e) {
            // Handle the case where the user entered an invalid integer
            System.out.println("Invalid input. Please enter a valid integer.");
            System.exit(1); // Exit the program with an error code 1
        }

        // Ask the user to enter the principal loan amount
        double principal = 0;
        try {
            System.out.print("Enter the amount financed(Total minus Down Payment, in USD): ");
            principal = scanner.nextDouble(); // Read the user's input for the principal
        } catch (Exception e) {
            // Handle the case where the user entered an invalid double
            System.out.println("Invalid input. Please enter a valid amount.");
            System.exit(1); // Exit the program with an error code 1
        }

        // Ask the user to enter the number of elements they want to perform calculations on
        double apr = 0;
        try {
            System.out.print("Enter the APR: ");
            apr = scanner.nextDouble(); // Read the user's input for the apr
        } catch (Exception e) {
            // Handle the case where the user entered an invalid double
            System.out.println("Invalid input. Please enter a valid APR.");
            System.exit(1); // Exit the program with an error code 1
        }
        scanner.close();

        System.out.println('$' + String.format("%.2f", calculate(years, principal, apr)));
    }

    public static double calculate(int years, double principal, double apr) {
        // Calculate the monthly mortgage payment
        double rate = (apr / 100)/12; //.04625
        double rate_plus_one = rate + 1; //
        int months = years * 12;
        double top_half = rate * Math.pow(rate_plus_one, months);
        double bottom_half = Math.pow(rate_plus_one, months) - 1;
        return principal * (top_half / bottom_half);
    }
}