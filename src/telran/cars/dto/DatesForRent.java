package telran.cars.dto;


import java.time.LocalDate;

public class DatesForRent {
    String carNumber;
    long driverId;
    LocalDate rentDate;
    int days;

    public DatesForRent(String carNumber, long driverId, LocalDate rentDate, int days) {
        this.carNumber = carNumber;
        this.driverId = driverId;
        this.rentDate = rentDate;
        this.days = days;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public long getDriverId() {
        return driverId;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public int getDays() {
        return days;
    }
}
