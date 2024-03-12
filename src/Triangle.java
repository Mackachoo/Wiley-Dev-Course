public class Triangle extends Shape{

    public Triangle(double a, double b, double c) {
        perimeter = a + b + c;
        double s = perimeter / 2;
        area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

}
