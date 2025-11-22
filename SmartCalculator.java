import java.util.Scanner;
public class SmartCalculator {
    public static double  add (double a ,double b){
        return a + b;
    }
    public static double  subtract (double a ,double b){
        return a - b;
    }
    public static double  multiply (double a ,double b){
        return a * b;
    }
    public static double  divide (double a ,double b){
        if (b == 0){
           System.out.println("Error: Cannot divide by zero!");
           return 0;
        }
        return a  / b;
    }
    public static void menu(){
System.out.println("Smart Calculator Menu:");
System.out.println("1. Add");
System.out.println("2. Subtract");
System.out.println("3. Multiply");
System.out.println("4. Divide");
System.out.println("5. Exit");

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double  num1, num2, result;
        do {
            menu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                num1 = sc.nextDouble();
                System.out.print("Enter second number: ");
                num2 = sc.nextDouble();
                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 4:
                        result = divide(num1, num2);
                        if (num2 != 0) {
                            System.out.println("Result: " + result);
                        }
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        System.out.println("Exiting Smart Calculator. Goodbye!");
        sc.close();


        
    }
}