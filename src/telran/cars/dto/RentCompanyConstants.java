package telran.cars.dto;

public interface RentCompanyConstants {
    String ADD_MODEL = "/model/add"; //POST
    String ADD_CAR = "/car/add"; //POST
    String ADD_DRIVER = "/driver/add"; //POST
    String GET_MODEL = "/model/get";//GET
    String GET_CAR = "/car/get";//GET
    String GET_DRIVER = "/driver/get";//GET
    String RENT_CAR = "/car/rent";//POST
    String RETURN_CAR = "/car/return";//POST
    String REMOVE_CAR = "/car/remove";//DELETE
    String GET_ALL_DRIVERS = "/driver/getAll";//GET
    String GET_ALL_MODELS = "/model/getAll";//GET
    String GET_ALL_CARS = "/car/getAll";
    String GET_CAR_DRIVERS = "/car/getDrivers";
    String GET_DRIVER_CARS = "/driver/getCars";
    String GET_ALL_RECORDS = "/common/getAllRecords";
    String GET_MODEL_PROFIT = "/common/getProfit";
    String GET_MOST_PROFITABLE_MODEL_NAMES = "/common/getMostProfitableModelNames";
    String GET_MOST_POPULAR_MODEL_NAMES = "/common/getMostPopularModelNames";
    String CLEAR = "/common/clear";//POST
    String GET_RETURNED_RECORDS_BY_DATES = "/common/getRecordsByDate";
}
