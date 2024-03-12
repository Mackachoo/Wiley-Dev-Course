public class Rectangle extends Shape{

    // Square
    public Rectangle(double size) {
        perimeter = 4 * size;
        area = Math.pow(size, 2);
    }

    // Rectangle
    public Rectangle(double height, double width) {
        perimeter = 2 * (height + width);
        area = height * width;
    }

}
