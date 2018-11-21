package telran.cars.dto;


import java.time.LocalDate;

public class ClearFactor {
    LocalDate currentDate;
    int days;

    public ClearFactor(LocalDate currentDate, int days) {
        this.currentDate = currentDate;
        this.days = days;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public int getDays() {
        return days;
    }
}
