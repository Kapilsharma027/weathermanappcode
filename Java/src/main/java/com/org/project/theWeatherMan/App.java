package com.org.project.theWeatherMan;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.org.project.theWeatherMan.dao.ProviderDao;
import com.org.project.theWeatherMan.services.ProviderRepository;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableScheduling
//@Configuration
//@PropertySource("application.properties")
//@EnableConfigurationProperties
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	CommandLineRunner init(ProviderRepository providerRepository) {
		return args -> {
//			Iterable<ProviderDao> providers = providerRepository.findAll();
//			System.out.println(providers.toString());
			ProviderDao provider = null;
//			if (providers == null) {
				System.out.println("HERE inside");
				try{
				provider = new ProviderDao();
				provider.setProvidername("weatherunlocked");
				providerRepository.save(provider);
				provider = new ProviderDao();
				provider.setProvidername("weatherbit");
				providerRepository.save(provider);
				provider = new ProviderDao();
				provider.setProvidername("accuweather");
				providerRepository.save(provider);
				provider = new ProviderDao();
				provider.setProvidername("darksky");
				providerRepository.save(provider);
				provider = new ProviderDao();
				provider.setProvidername("openweathermap");
				providerRepository.save(provider);
				}
				catch(Exception e){
					System.out.println(e);
				}
//			}
		};
	}

}
