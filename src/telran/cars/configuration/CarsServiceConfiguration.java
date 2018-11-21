package telran.cars.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.utils.Persistable;

@Configuration
@ManagedResource
public class CarsServiceConfiguration{
	@Value(value="${fileName}")
	
	String fileName;
	@Autowired
	IRentCompany rentCompany;
	@Bean
	public IRentCompany getRentCompany() {
		return RentCompanyEmbedded.restoreFromFile(fileName);
	}
	@PreDestroy
	public void save() {
		System.out.println(rentCompany.getAllModelNames());
		((Persistable) rentCompany).saveToFile(fileName);
		System.out.println("Saved to file "+fileName);
	}
}
