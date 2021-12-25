package com.foodbox.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.foodbox.entity.Food;
import com.foodbox.entity.FoodCuisine;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
		
		//disable HTTP methods for Food: POST, PUT and DELETE
		config.getExposureConfiguration()
		      .forDomainType(Food.class)
		      .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
		      .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		//disable HTTP methods for FoodCuisine: POST, PUT and DELETE
				config.getExposureConfiguration()
				      .forDomainType(FoodCuisine.class)
				      .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				      .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
			  
	}

}
