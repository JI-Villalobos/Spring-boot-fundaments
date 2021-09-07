package com.fundaments.boot.fundaments;

import com.fundaments.boot.fundaments.bean.MyBean;
import com.fundaments.boot.fundaments.bean.MyBeanWithDependency;
import com.fundaments.boot.fundaments.bean.MyBeanWithProperties;
import com.fundaments.boot.fundaments.component.ComponentDependency;
import com.fundaments.boot.fundaments.entity.Owner;
import com.fundaments.boot.fundaments.pojo.UserPojo;
import com.fundaments.boot.fundaments.repository.OwnerRepository;
import com.fundaments.boot.fundaments.utils.ImportanceLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentsApplication.class);

	private final ComponentDependency componentDependency;
	private final MyBean myBean;
	private final MyBeanWithDependency myBeanWithDependency;
	private final MyBeanWithProperties myBeanWithProperties;
	private final UserPojo userPojo;

	private OwnerRepository ownerRepository;

	//On recent versions it is not necessary annotate with @Autowired
	//If we have two or more classes implementing our dependency we have to specify  which class we're going to inject with @Qualifier
	//The syntax for the Qualifier is renamed the class in camel case, ex. MiClass -> miClass
	public FundamentsApplication(
			@Qualifier("componentToImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo,
			OwnerRepository ownerRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.ownerRepository = ownerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createIPO();
		saveOwnerInDB();
		getOwnerByEmail();
	}

	private void getOwnerByEmail(){
		LOGGER.info("Owner data: " + ownerRepository.findByEmail("anaval@owner.com")
				.orElseThrow(() -> new RuntimeException("Owner not found")));

		ownerRepository.findAndSort("Dan", Sort.by("id").descending())
				.forEach(owner -> LOGGER.info("Owner in sort: " + owner));

		ownerRepository.findByName("Dan Vega")
				.forEach(owner -> LOGGER.info("username: " + owner));

		ownerRepository.findAll()
				.forEach(owner -> LOGGER.info("Owner info: " +  owner));
	}

	private void createIPO(){
		System.out.println("token: " + componentDependency.token() + " expires at " + myBean.to() + myBeanWithDependency.ipo(ImportanceLevel.HIGH));
		System.out.println("Contract owner: " + myBeanWithProperties.function());
		System.out.println("IPO owner: " + userPojo.getEmail() + ":" + userPojo.getPassword());
		LOGGER.error("Error message");
	}

	private void saveOwnerInDB(){
		Owner owner1 = new Owner("Dan Vega", "dn@owner.com", LocalDate.of(1966, 10, 23));
		Owner owner2 = new Owner("Orish Mu", "gil@owner.com", LocalDate.of(1996, 1, 3));
		Owner owner3 = new Owner("Dany Van Frand", "diva@owner.com", LocalDate.of(1986, 8, 13));
		Owner owner4 = new Owner("Ana Valtradh", "anaval@owner.com", LocalDate.of(1999, 12, 31));
		Owner owner5 = new Owner("Daniela Rivera", "dari@owner.com", LocalDate.of(2000, 1, 6));

		List<Owner> list = Arrays.asList(owner1, owner2, owner3, owner4, owner5);
		list.forEach(ownerRepository::save);
	}
}
