package com.samulitori.tori;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

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
			LocalDate ld = LocalDate.now();
			Locale finLocale = new Locale("fi", "FI");
			DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(finLocale);
			
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
			categoryRepo.save(new Category("Sisustus ja huonekalut"));


			listingRepo.save(new Listing("bmw 330d","ajettu 400tkm ostakaa plz", 19990, categoryRepo.findByName("Autot").get(0), userRepo.findByUsername("seppo"), dateFormat.format(ld)));
			listingRepo.save(new Listing("Sänky","Runkopatja ikää sultan 90x200cm", 100, categoryRepo.findByName("Sisustus ja huonekalut").get(0), userRepo.findByUsername("seppo"), dateFormat.format(ld)));
			listingRepo.save(new Listing("pelitietokone i5 gtx-1060","hyvässä kunnossa pelejä pelattu", 500, categoryRepo.findByName("Tietokoneet").get(0), userRepo.findByUsername("seppo"), dateFormat.format(ld)));
			listingRepo.save(new Listing("call of duty mw2","hyvässä kunnossa", 10, categoryRepo.findByName("Pelit").get(0), userRepo.findByUsername("seppo"), dateFormat.format(ld)));
			listingRepo.save(new Listing("Pöytä","60cm korkea", 40, categoryRepo.findByName("Sisustus ja huonekalut").get(0), userRepo.findByUsername("seppo"), dateFormat.format(ld)));
			listingRepo.save(new Listing("monitori 24\"","ei oo kuolleita pikseleitä", 200, categoryRepo.findByName("Tietokoneet").get(0), userRepo.findByUsername("seppo"), dateFormat.format(ld)));


						
		};
	}
}
