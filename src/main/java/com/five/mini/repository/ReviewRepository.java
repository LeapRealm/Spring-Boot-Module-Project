package com.five.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.five.mini.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
}