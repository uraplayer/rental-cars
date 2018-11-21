package telran.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@SpringBootApplication
@ManagedResource
public class RentCompanyAppl {
	static ConfigurableApplicationContext ctx;

	@ManagedOperation
	public void stop() {
		ctx.close();
	}

	public static void main(String[] args) {
		ctx = SpringApplication.run(RentCompanyAppl.class, args);
	}
}
