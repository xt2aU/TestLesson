interface Shape {
    default double calculatePerimeter() {
        return 0;
    }

    default double calculateArea() {
        return 0;
    }

    String getFillColor();
    String getBorderColor();
}
//Создаём класс Круг
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
//Переопределяем периметр круга
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
//Переопределяем площадь круга
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
//Создаём класс Прямоугольник
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
//Переопределяем периметр
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
//Переопределяем площадь
    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
//Создаём класс Треугольник
class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
//Переопределяем периметр
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
//Переопределяем площадь
    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Red", "Blue");
        Shape rectangle = new Rectangle(4, 6, "Green", "Black");
        Shape triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Периметр: " + shape.calculatePerimeter());
        System.out.println("Площадь: " + shape.calculateArea());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println();
    }
}