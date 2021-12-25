package com.foodbox.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.foodbox.entity.Food;

@CrossOrigin("http://localhost:4200")
public interface FoodRepository extends JpaRepository<Food, Long> {
	
//	@Query(value = "SELECT f FROM Food f WHERE f.name LIKE '%' || :keyword || '%'"
//			+ " OR f.cuisine LIKE '%' || :keyword || '%'" )
//	public List<Food> search(@Param("keyword") String keyword);

}
