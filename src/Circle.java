public class Circle extends Shape {

    public Circle(double radius) {
        perimeter = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
    }
}
