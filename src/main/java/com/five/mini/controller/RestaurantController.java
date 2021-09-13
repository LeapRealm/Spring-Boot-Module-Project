package com.five.mini.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.five.mini.model.Restaurant;
import com.five.mini.model.Review;
import com.five.mini.model.UserList;
import com.five.mini.repository.RestaurantRepository;
import com.five.mini.repository.ReviewRepository;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/restaurant/{id}")
	public String restaurantView(Model model, @PathVariable("id") long id) {
		Optional<Restaurant> data = restaurantRepository.findById(id);
		Restaurant restaurant = data.get();
		List<Review> review = reviewRepository.findAll();
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("review", review);
		return "restaurantView";
	}
	@PostMapping("/restaurant/{id}")
	public String restaurantPost(
		@ModelAttribute Review review, @PathVariable("id") long id) {
		UserList userlist = (UserList) session.getAttribute("user");
		String userName = userlist.getUserName();
		review.setUserName(userName);
		review.setRestaurantNum(id);
		reviewRepository.save(review);
		return "redirect:/restaurant/" + id;
	}

}
