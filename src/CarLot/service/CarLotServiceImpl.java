package CarLot.service;

import CarLot.dao.CarLotDAO;
import CarLot.dao.CarLotDAOImpl;
import CarLot.dto.Car;
import CarLot.dto.CarKey;
import CarLot.exception.NoSuchCarException;
import CarLot.exception.OverpaidPriceException;
import CarLot.exception.UnderpaidPriceException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarLotServiceImpl implements CarLotService {

    final CarLotDAO dao = new CarLotDAOImpl();

    @Override
    public Car getACar(String VIN) {
        dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return getAllCars().stream().filter(car -> Objects.equals(car.getColor(), color)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        return getAllCars().stream().filter(car -> car.getPrice().compareTo(maxPrice) < 0).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        List<Car> cars = new ArrayList<>();
        for (Car car : getAllCars()) {
            if (Objects.equals(car.getMake(), make) && Objects.equals(car.getModel(), model)) {
                cars.add(car);
            }
        }
        return cars;

    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        return null;
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        return null;
    }
}
