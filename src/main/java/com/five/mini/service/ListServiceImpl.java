package com.five.mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.five.mini.model.Restaurant;
import com.five.mini.repository.RestaurantRepository;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> getGugunRestaurants(String gugun) {
		return restaurantRepository.findByGugunContaining(gugun);
	}

	@Override
	public List<Restaurant> getBsnsCondRestaurants(String bsnsCond) {
		return restaurantRepository.findByBsnsCondContaining(bsnsCond);
	}

	@Override
	public List<Restaurant> getRestaurants(String gugun, String bsnsCond) {
		return restaurantRepository.findByGugunContainingAndBsnsCondContaining(gugun, bsnsCond);
	}
}