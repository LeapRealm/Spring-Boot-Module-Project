package com.five.mini.service;

import java.util.List;

import com.five.mini.model.Restaurant;

public interface HomeService {
	public List<Restaurant> getNearestRestaurant(String addrJibun);
}