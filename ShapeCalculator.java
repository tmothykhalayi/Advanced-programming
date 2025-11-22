import java.util.*;

// ===== Interface =====
interface Printable {
    void print();
}

// ===== Abstract Class =====
abstract class Shape {
    public abstract double area();
}

// ===== Subclasses =====
class Circle extends Shape implements Printable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void print() {
        System.out.printf("Circle -> Radius: %.2f | Area: %.2f%n", radius, area());
    }
}

class Rectangle extends Shape implements Printable {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public void print() {
        System.out.printf("Rectangle -> Length: %.2f Width: %.2f | Area: %.2f%n", length, width, area());
    }
}

class Triangle extends Shape implements Printable {
    private double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public void print() {
        System.out.printf("Triangle -> Base: %.2f Height: %.2f | Area: %.2f%n", base, height, area());
    }
}

// ===== Main Program =====
public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Printable> shapes = new ArrayList<>();

        while (true) {
            System.out.println("\n===== SHAPE AREA CALCULATOR =====");
            System.out.println("1. Add Circle");
            System.out.println("2. Add Rectangle");
            System.out.println("3. Add Triangle");
            System.out.println("4. View All Shapes");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double radius = sc.nextDouble();
                    shapes.add(new Circle(radius));
                    break;

                case 2:
                    System.out.print("Enter length: ");
                    double length = sc.nextDouble();
                    System.out.print("Enter width: ");
                    double width = sc.nextDouble();
                    shapes.add(new Rectangle(length, width));
                    break;

                case 3:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double height = sc.nextDouble();
                    shapes.add(new Triangle(base, height));
                    break;

                case 4:
                    System.out.println("\nAll Shapes:");
                    if (shapes.isEmpty()) {
                        System.out.println("No shapes added yet.");
                    } else {
                        for (Printable p : shapes) p.print();
                    }
                    break;

                case 5:
                    System.out.println("Exiting Shape Calculator...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
