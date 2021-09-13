package com.five.mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.five.mini.model.Restaurant;
import com.five.mini.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@GetMapping("/json/getNearestRestaurant")
	public List<Restaurant> getNearestRestaurant(@RequestParam String addrJibun) {
		return homeService.getNearestRestaurant(addrJibun);
	}

	
//  DB에 데이터 세팅할때 사용하세요 (한번만 /save 주소로 접속하면 됨)
//	@Autowired
//	RestaurantRepository restaurantRepository;
//	
//	@ResponseBody
//	@GetMapping("/save")
//	public String save() {
//		RestTemplate rt = new RestTemplate();
//        Restaurant[] datas = rt.getForObject("https://leaprealm.com/json/restaurantList.json", Restaurant[].class);
//        List<Restaurant> list = Arrays.asList(datas);
//        restaurantRepository.saveAll(list);
//        return "saved";
//	}
}