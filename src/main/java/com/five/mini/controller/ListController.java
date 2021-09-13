package com.five.mini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.five.mini.service.ListService;

@Controller
public class ListController {

   @Autowired
   ListService listService;

   @GetMapping("/list")
   public String list(@RequestParam(defaultValue = "전체") String gugun,
         @RequestParam(defaultValue = "전체") String bsnsCond, Model model) {
      //restaurant DB 내에 있는 gugun과 bsnsCond를 가져옴
      model.addAttribute("gugun", gugun);
      model.addAttribute("bsnsCond", bsnsCond);
      //list.html에서 구군과 업종을 검색하기 위해서 option을 선택할때 필요한 배열을 생성하여 반환
      String[] gugunList = { "강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구",
            "영도구", "중구", "해운대구" };
      model.addAttribute("gugunList", gugunList);
      String[] bsnsCondList = { "경양식", "냉면집", "복어취급", "분식", "숯불구이", "양식", "외국음식전문점", "일식", "중국식", "탕류", "한식", "회집",
            "기타" };
      model.addAttribute("bsnsCondList", bsnsCondList);
      //최종적으로 각 상황에 맞는 식당리스트를 반환
      if ((gugun.equals("전체")) && (bsnsCond.equals("전체"))) {      //전체검색은 모두 검색
         model.addAttribute("restaurantList", listService.getAllRestaurants());
      } else if (gugun.equals("전체")) {   //구군을 전체로 두면 업종만 검색
         model.addAttribute("restaurantList", listService.getBsnsCondRestaurants(bsnsCond));
      } else if (bsnsCond.equals("전체")) {      //업종을 전체로 두면 구군만 검색
         model.addAttribute("restaurantList", listService.getGugunRestaurants(gugun));
      } else {   //두가지 모두 검색하면 두개다 AND로 검색
         model.addAttribute("restaurantList", listService.getRestaurants(gugun, bsnsCond));
      }
      return "list";
   }
}