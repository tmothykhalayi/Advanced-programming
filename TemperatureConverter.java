import java.util.Scanner;
import java.text.DecimalFormat;

public class TemperatureConverter {

    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#.##");

    // ===== Conversion Methods =====
    public static double cToF(double c) { return (c * 9/5) + 32; }
    public static double fToC(double f) { return (f - 32) * 5/9; }
    public static double cToK(double c) { return c + 273.15; }
    public static double kToC(double k) { return k - 273.15; }
    public static double fToK(double f) { return cToK(fToC(f)); }
    public static double kToF(double k) { return cToF(kToC(k)); }
    public static double cToR(double c) { return (c + 273.15) * 9/5; }
    public static double rToC(double r) { return (r - 491.67) * 5/9; }
    public static double cToRe(double c) { return c * 4/5; } 
    public static double reToC(double re) { return re * 5/4; }

    // ===== Menu =====
    public static void menu() {
        System.out.println("\n===== ADVANCED TEMPERATURE CONVERTER =====");
        System.out.println("1. Celsius ↔ Fahrenheit");
        System.out.println("2. Celsius ↔ Kelvin");
        System.out.println("3. Celsius ↔ Rankine");
        System.out.println("4. Celsius ↔ Reaumur");
        System.out.println("5. Fahrenheit ↔ Kelvin");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    // ===== Main Program =====
    public static void main(String[] args) {
        int choice;
        do {
            menu();
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // discard invalid input
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature: ");
                    double tempC1 = sc.nextDouble();
                    System.out.println(tempC1 + " °C = " + df.format(cToF(tempC1)) + " °F");
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double tempF = sc.nextDouble();
                    System.out.println(tempF + " °F = " + df.format(fToC(tempF)) + " °C");
                    break;

                case 2:
                    System.out.print("Enter temperature in Celsius: ");
                    double tempC2 = sc.nextDouble();
                    System.out.println(tempC2 + " °C = " + df.format(cToK(tempC2)) + " K");
                    System.out.print("Enter temperature in Kelvin: ");
                    double tempK = sc.nextDouble();
                    System.out.println(tempK + " K = " + df.format(kToC(tempK)) + " °C");
                    break;

                case 3:
                    System.out.print("Enter temperature in Celsius: ");
                    double tempC3 = sc.nextDouble();
                    System.out.println(tempC3 + " °C = " + df.format(cToR(tempC3)) + " °R");
                    System.out.print("Enter temperature in Rankine: ");
                    double tempR = sc.nextDouble();
                    System.out.println(tempR + " °R = " + df.format(rToC(tempR)) + " °C");
                    break;

                case 4:
                    System.out.print("Enter temperature in Celsius: ");
                    double tempC4 = sc.nextDouble();
                    System.out.println(tempC4 + " °C = " + df.format(cToRe(tempC4)) + " °Re");
                    System.out.print("Enter temperature in Reaumur: ");
                    double tempRe = sc.nextDouble();
                    System.out.println(tempRe + " °Re = " + df.format(reToC(tempRe)) + " °C");
                    break;

                case 5:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double tempF2 = sc.nextDouble();
                    System.out.println(tempF2 + " °F = " + df.format(fToK(tempF2)) + " K");
                    System.out.print("Enter temperature in Kelvin: ");
                    double tempK2 = sc.nextDouble();
                    System.out.println(tempK2 + " K = " + df.format(kToF(tempK2)) + " °F");
                    break;

                case 6:
                    System.out.println("Exiting Temperature Converter...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
        sc.close();
    }
}
