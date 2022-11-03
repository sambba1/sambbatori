package com.samulitori.tori;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.samulitori.tori.domain.Category;
import com.samulitori.tori.domain.CategoryRepository;
import com.samulitori.tori.domain.Listing;
import com.samulitori.tori.domain.ListingRepository;
import com.samulitori.tori.domain.User;
import com.samulitori.tori.domain.UserRepository;

@SpringBootApplication
public class ToriApplication {


	public static void main(String[] args) {
		SpringApplication.run(ToriApplication.class, args);
	}

	@Bean
	public CommandLineRunner moti(ListingRepository listingRepo, CategoryRepository categoryRepo, UserRepository userRepo){
		return (args) -> {

			userRepo.save(new User("seppo", "$2y$10$iyEr.tfpe9q2NrY0B9ayAeVsd4ljb5VHP8y/ioV/rFXrz2fv624yG", "USER"));
			userRepo.save(new User("admin", "$2y$10$6P79CpftG0MpMstXlAgieuIZA3fRCD89iXHc8L6zTAcTLPyxjDAse", "ADMIN"));

			categoryRepo.save(new Category("Autot"));
			categoryRepo.save(new Category("Kodinkoneet"));
			categoryRepo.save(new Category("Vaatteet ja kengät"));
			categoryRepo.save(new Category("Pelit"));
			categoryRepo.save(new Category("Elokuvat"));
			categoryRepo.save(new Category("Urheilu ja ulkoilu"));
			categoryRepo.save(new Category("Elektroniikka"));
			categoryRepo.save(new Category("Tietokoneet"));
			categoryRepo.save(new Category("Puhelimet"));


			listingRepo.save(new Listing("bmw 330d","ajettu 400tkm ostakaa plz", 19990, categoryRepo.findByName("Autot").get(0), userRepo.findByUsername("seppo")));


						
		};
	}
}
