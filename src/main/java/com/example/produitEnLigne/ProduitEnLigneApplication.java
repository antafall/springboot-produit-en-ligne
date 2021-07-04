package com.example.produitEnLigne;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.produitEnLigne.dao.CategoryRepository;
import com.example.produitEnLigne.dao.ProductRepository;
import com.example.produitEnLigne.entities.Category;
import com.example.produitEnLigne.entities.Product;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ProduitEnLigneApplication implements CommandLineRunner{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProduitEnLigneApplication.class, args);
	}
	@Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.save(new Category("Robe",null,null,null));
		categoryRepository.save(new Category("Voile",null,null,null));
		categoryRepository.save(new Category("Abaya",null,null,null));
		Random rnd=new Random();
		categoryRepository.findAll().forEach(c->{
			for (int i = 0; i<10; i++) {
				Product p=new Product();
				p.setName(RandomString.make(18));
				p.setPrixActuel(100+rnd.nextInt(10000));
				p.setDisponible(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setProduitSelectionne(rnd.nextBoolean());
				p.setNomPhoto("unknown.jpeg");
				p.setCategory(c);
				productRepository.save(p);
				
			}
			
			
		});
	}

}
