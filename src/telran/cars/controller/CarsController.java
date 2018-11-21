package telran.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.*;

import telran.cars.dto.*;
import static telran.cars.dto.RentCompanyConstants.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import telran.cars.model.IRentCompany;

@RestController
@ManagedResource
public class CarsController {
	@Autowired
	IRentCompany rentCompany;
	@Value(value="${fine_percent:15}")
	int finePercent;
	@Value(value="${gas_price:10}")
	int gasPrice;

	@PostConstruct
	void settings() {
		setFinePercent(finePercent);
		setGasPrice(gasPrice);
	}
	@ManagedAttribute
	public int getFinePercent() {
		return rentCompany.getFinePercent();
	}

	@ManagedAttribute
	public int getGasPrice() {
		return rentCompany.getGasPrice();
	}

	@ManagedAttribute
	public void setFinePercent(int finePercent) {
		rentCompany.setFinePercent(finePercent);
	}

	@ManagedAttribute
	public void setGasPrice(int gasPrice) {
		rentCompany.setGasPrice(gasPrice);
	}

	@PostMapping(value = ADD_MODEL)
	public CarsReturnCode addModel(@RequestBody Model model) {
		return rentCompany.addModel(model);
	}

	@PostMapping(value = ADD_CAR)
	public CarsReturnCode addCar(@RequestBody Car car) {
		return rentCompany.addCar(car);
	}

	@PostMapping(value = ADD_DRIVER)
	public CarsReturnCode AddDriver(@RequestBody Driver driver) {
		return rentCompany.addDriver(driver);
	}

	@GetMapping(value = GET_MODEL+"/{model_name}")
	public Model getModel(@PathVariable("model_name") String modelName) {
		return rentCompany.getModel(modelName);
	}

	@GetMapping(value = GET_CAR+"/{carNumber}")
	public Car GetCar(@PathVariable("carNumber") String carNumber) {
		return rentCompany.getCar(carNumber);
	}

	@GetMapping(value = GET_DRIVER+"/{licenseId}")
	public Driver getDriver(@PathVariable("licenseId") long licenseId) {
		return rentCompany.getDriver(licenseId);
	}

	@PostMapping(value = RENT_CAR)
	public CarsReturnCode rentCar(@RequestBody DatesForRent dataRent) {
		return rentCompany.rentCar(dataRent.getCarNumber(), dataRent.getDriverId(), dataRent.getRentDate(),
				dataRent.getDays());
	}

	@PostMapping(value = RETURN_CAR)
	public CarsReturnCode returnCar(@RequestBody DatesForReturn dataReturn) {
		return rentCompany.returnCar(dataReturn.getCarNumber(), dataReturn.getReturnDate(),
				dataReturn.getGasTankPercent(), dataReturn.getDamages());
	}

	@DeleteMapping(value = REMOVE_CAR+"/{carNumber}")
	public CarsReturnCode removeCar(@PathVariable("carNumber") String carNumber) {
		return rentCompany.removeCar(carNumber);
	}

	@GetMapping(value = GET_ALL_DRIVERS)
	public List<Driver> getAllDrivers() {
		return rentCompany.getAllDrivers().collect(Collectors.toList());
	}

	@GetMapping(value = GET_ALL_MODELS)
	public List<String> getAllModels() {
		return rentCompany.getAllModelNames();
	}

	@GetMapping(value = GET_ALL_CARS)
	public List<Car> getAllCars() {
		return rentCompany.getAllCars().collect(Collectors.toList());
	}

	@GetMapping(value = GET_CAR_DRIVERS+"/{carNumber}")
	public List<Driver> getCarDrivers(@PathVariable("carNumber") String carNumber) {
		return rentCompany.getCarDrivers(carNumber);
	}

	@GetMapping(value = GET_DRIVER_CARS+"/{licenseId}")
	public List<Car> getDriverCars(@PathVariable("licenseId") long licenseId) {
		return rentCompany.getDriverCars(licenseId);
	}

	@GetMapping(value = GET_ALL_RECORDS)
	public List<RentRecord> getAllRecords() {
		return rentCompany.getAllRecords().collect(Collectors.toList());
	}

	@GetMapping(value = GET_MODEL_PROFIT+"/{modelName}")
	public double getModelProfit(@PathVariable("modelName") String modelName) {
		return rentCompany.getModelProfit(modelName);
	}

	@GetMapping(value = GET_MOST_PROFITABLE_MODEL_NAMES)
	public List<String> getMostProfitModelNames() {
		return rentCompany.getMostProfitModelNames();
	}

	@GetMapping(value = GET_MOST_POPULAR_MODEL_NAMES)
	public List<String> getMostPopularModelNames() {
		return rentCompany.getMostPopularModelNames();
	}

	@PostMapping(value = CLEAR)
	public List<Car> clear(@RequestBody ClearFactor clf) {
		return rentCompany.clear(clf.getCurrentDate(), clf.getDays());
	}

	@GetMapping(value = GET_RETURNED_RECORDS_BY_DATES)
	public List<RentRecord> getReturnedRecordsByDates(@RequestParam("from")String from, @RequestParam("to") String to) {
		LocalDate fromDate = LocalDate.parse(from);
		LocalDate toDate = LocalDate.parse(to);
		return rentCompany.getReturnedRecordsByDates(fromDate, toDate).collect(Collectors.toList());
	}
}
