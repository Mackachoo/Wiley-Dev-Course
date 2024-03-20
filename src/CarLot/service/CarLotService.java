package CarLot.service;

import CarLot.dto.Car;
import CarLot.dto.CarKey;
import CarLot.exception.NoSuchCarException;
import CarLot.exception.OverpaidPriceException;
import CarLot.exception.UnderpaidPriceException;

import java.math.BigDecimal;
import java.util.List;

public interface CarLotService {

    public Car getACar(String VIN);
    public List<Car> getAllCars();
    public List<Car> getCarsByColor(String color);
    public List<Car> getCarsInBudget(BigDecimal maxPrice);
    public List<Car> getCarByMakeAndModel(String make, String model);

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
            throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException,
            OverpaidPriceException,
            UnderpaidPriceException;
}
