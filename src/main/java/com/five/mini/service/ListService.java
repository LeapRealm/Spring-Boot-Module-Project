package com.five.mini.service;

import java.util.List;

import com.five.mini.model.Restaurant;

public interface ListService {
	public List<Restaurant> getAllRestaurants();
	public List<Restaurant> getGugunRestaurants(String gugun);
	public List<Restaurant> getBsnsCondRestaurants(String bsnsCond);
	public List<Restaurant> getRestaurants(String gugun, String bsnsCond);
}