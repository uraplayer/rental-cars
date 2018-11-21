package telran.cars.dto;


import java.time.LocalDate;

public class DatesForReturn {
    String carNumber;
    LocalDate returnDate;
    int gasTankPercent;
    int damages;

    public DatesForReturn(String carNumber, LocalDate returnDate, int gasTankPercent, int damages) {
        this.carNumber = carNumber;
        this.returnDate = returnDate;
        this.gasTankPercent = gasTankPercent;
        this.damages = damages;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getGasTankPercent() {
        return gasTankPercent;
    }

    public int getDamages() {
        return damages;
    }
}
