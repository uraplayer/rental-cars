package telran.cars.model;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

import telran.cars.dto.Model;
import telran.cars.dto.RentRecord;
public abstract class AbstractRentCompany implements IRentCompany,Serializable{
	protected int finePercent = 15;
	protected int gasPrice = 10;
	public int getFinePercent() {
		return finePercent;
	}
	public int getGasPrice() {
		return gasPrice;
	}
	public void setFinePercent(int finePercent) {
		this.finePercent = finePercent;
	}
	public void setGasPrice(int gasPrice) {
		this.gasPrice = gasPrice;
	}

	@Override
	public String toString() {
		return "AbstractRentCompany [finePercent=" + finePercent + ", gasPrice=" + gasPrice + "]";
	}

	protected float calculate_cost(RentRecord rentRecord, String modelName) {
		// Model my_model = models.get
		// (cars.get(rentRecord.getCarNumber()).getModelName());
		Model my_model = getModel(modelName);
		int price_per_day = my_model.getPriceDay();
		int days = rentRecord.getRentDays();
		float gas_fine =
		(100 - rentRecord.getGasTankPercent())
		* my_model.getGasTank() * (getGasPrice()) / 100;
		int delay = (int)
		(ChronoUnit.DAYS.between
		(rentRecord.getRentDate(),
				rentRecord.getReturnDate()) - days);
		if (delay < 0)
			delay = 0;
		float day_fine = delay * (price_per_day + price_per_day * getFinePercent() / 100);
		float sum = price_per_day * days + gas_fine + day_fine;
		return sum;
	}
}
