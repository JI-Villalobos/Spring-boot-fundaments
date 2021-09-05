package com.fundaments.boot.fundaments;

import com.fundaments.boot.fundaments.bean.MyBean;
import com.fundaments.boot.fundaments.bean.MyBeanWithDependency;
import com.fundaments.boot.fundaments.bean.MyBeanWithProperties;
import com.fundaments.boot.fundaments.component.ComponentDependency;
import com.fundaments.boot.fundaments.pojo.UserPojo;
import com.fundaments.boot.fundaments.utils.ImportanceLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentsApplication.class);

	private final ComponentDependency componentDependency;
	private final MyBean myBean;
	private final MyBeanWithDependency myBeanWithDependency;
	private final MyBeanWithProperties myBeanWithProperties;
	private final UserPojo userPojo;

	//On recent versions it is not necessary annotate with @Autowired
	//If we have two or more classes implementing our dependency we have to specify  which class we're going to inject with @Qualifier
	//The syntax for the Qualifier is renamed the class in camel case, ex. MiClass -> miClass
	public FundamentsApplication(
			@Qualifier("componentToImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("token: " + componentDependency.token() + " expires at " + myBean.to() + myBeanWithDependency.ipo(ImportanceLevel.HIGH));
		System.out.println("Contract owner: " + myBeanWithProperties.function());
		System.out.println("IPO owner: " + userPojo.getEmail() + ":" + userPojo.getPassword());
		LOGGER.error("Error message");
	}
}
