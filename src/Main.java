public class Main {
    public static void main(String[] args) {

       System.out.println("Hello and welcome!");
       Triangle test = new Triangle(4.0, 7.0, 10.0);
       System.out.printf("The triangles area is %.1f and it's perimeter is %.1f", test.getArea(), test.getPerimeter());

    }
}