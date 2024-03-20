package CarLot.dto;

public class CarKey {
    private String VIN;
    private boolean laserCut;

    public CarKey(String VIN) {
        this.VIN = VIN;
    }

    public CarKey(String VIN, boolean laserCut) {
        this.VIN = VIN;
        this.laserCut = laserCut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarKey carKey = (CarKey) o;

        return VIN.equals(carKey.VIN);
    }

    @Override
    public int hashCode() {
        return VIN.hashCode();
    }

    public String getVIN() {
        return VIN;
    }

    public boolean isLaserCut() {
        return laserCut;
    }

    public void setLaserCut(boolean laserCut) {
        this.laserCut = laserCut;
    }
}
