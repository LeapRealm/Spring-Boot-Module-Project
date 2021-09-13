package com.five.mini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.five.mini.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	List<Restaurant> findByAddrJibunContaining(String addrJibun);
	List<Restaurant> findByGugunContaining(String gugun);
	List<Restaurant> findByBsnsCondContaining(String bsnsCond);
	List<Restaurant> findByGugunContainingAndBsnsCondContaining(String gugun, String bsnsCond);
}