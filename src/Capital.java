public class Capital {
    private final String name;
    private long population;


    private double area;

    public Capital(String name, long population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public Capital(String name, String population, String area) {
        this.name = name;
        this.population = Long.parseLong(population);
        this.area = Double.parseDouble(area);
    }

    @Override
    public String toString() {
        return name;
    }

    public long getPop() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public void setPop(long population) {
        this.population = population;
    }

    public void setArea(double area) {
        this.area = area;
    }

}
