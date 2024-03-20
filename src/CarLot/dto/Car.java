package CarLot.dto;

import java.math.BigDecimal;

public class Car {
    private String VIN;
    private String make;
    private String model;
    private String color;

    private BigDecimal price;
    private long odometerMiles;

    private CarKey key;

    public Car(String VIN) {
        this.VIN = VIN;
    }

    public Car(String VIN, String make, String model, String color, BigDecimal price, long odometerMiles, CarKey key) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
        this.odometerMiles = odometerMiles;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return VIN.equals(car.VIN);
    }

    @Override
    public int hashCode() {
        return VIN.hashCode();
    }

    public String getVIN() {
        return VIN;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getOdometerMiles() {
        return odometerMiles;
    }

    public CarKey getKey() {
        return key;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOdometerMiles(long odometerMiles) {
        this.odometerMiles = odometerMiles;
    }

    public void setKey(CarKey key) {
        this.key = key;
    }
}
