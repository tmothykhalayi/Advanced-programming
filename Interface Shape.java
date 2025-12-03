interface Shape  {
    double getArea();

}
//Rectanlge class that implements Shape interface
class  Rectangle implements Shape {
    private double length ;
    private double width ;
    public Rectangle (double length , double width ){
        this.length = length ;
        this.width = width ;
    }
    @Override
    public double getArea() {
        return length * width;
    }
    }
    //Circle class that implements Shape interface
    class Circle implements Shape {
        private double radius ;
        public Circle (double radius ){
            this.radius = radius ;
        }
        @Override
        public double getArea(){
            return Math.PI *radius*radius;
        }
    }

        //Triangle class that implements Shape interface
        class Triangle  implements Shape {
            private double base ;
            private double height ;
            public Triangle (double base ,double height ){
                this.base =base ;
                this.height =height;
            }
            @Override
            public double getArea(){
                return 0.5 *base*height;
            }
        }
    public class Main {
        public static void main(String[] args) {
            Shape rectangle = new Rectangle(10, 15);
            Shape circle = new Circle(7);
            Shape triangle = new Triangle(8, 12);

            System.out.println("Rectangle Area: " + rectangle.getArea());
            System.out.println("Circle Area: " + circle.getArea());
            System.out.println("Triangle Area: " + triangle.getArea());
        }
    }
    
