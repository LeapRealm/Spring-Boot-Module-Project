package com.five.mini.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Restaurant {

	@Id
    private Long id;
	
    private String image;
    private String bsnsSector;
    private String bsnsCond;
    private String bsnsNm;
    private String addrRoad;
    private String addrJibun;
    private String menu;
    private String tel;
    private String specDate;
    private String ovrdDate;
    private String gugun;
    private String dataDay;
    private String lat;
    private String lng;
}