package com.five.mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.five.mini.model.Restaurant;
import com.five.mini.service.MapService;

@Controller
public class MapController {

	@Autowired
	MapService mapService;

	@GetMapping("/map")
	public String map() {
		return "map";
	}

	@GetMapping("/map/getPoint")
	@ResponseBody
	public List<Restaurant> getRestaurant() {
		return mapService.getRestaurant();
	}
}