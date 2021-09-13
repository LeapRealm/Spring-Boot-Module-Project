package com.five.mini.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.five.mini.model.UserList;
import com.five.mini.repository.UserListRepository;

@Controller
public class UserListController {

   @Autowired
   UserListRepository userListRepository;
   
   @Autowired
   HttpSession session;
   
   @GetMapping("/login")
   public String login() {
      return "login";
   }
   
   @GetMapping("/signUp")
   public String signUp() {
      return "signUp";
   }
   
   @GetMapping("/logout")
   public String logout() {
      session.invalidate();
      return "redirect:/";
   }

   @PostMapping("/login")
   public String loginPost(@ModelAttribute UserList userList, HttpServletResponse response
                     ) throws Exception {
      //유저리스트에 존재하는 현재 회원가입되어있는 유저 DB에서 이메일과 비밀번호를 AND로 검색하여서 조건문 실행
      UserList dbUserList = userListRepository.findByUserEmailAndUserPassword(userList.getUserEmail(), userList.getUserPassword());
      if(dbUserList != null) {
         //NULL값이 아닐경우, 즉 이메일과 비밀번호가 모두 일치할 경우 == 회원이 있을 경우
         session.setAttribute("user", dbUserList);   //session에 현재 유저 정보 저장
      }
      else {   //일치하는 정보가 없을 경우 알림을 띄워주고 뒤로가기 실행(로그인창으로 다시 이동한다)
         response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
            out.flush();
      }
      System.out.println(dbUserList);
      return "redirect:/";
   }

   @PostMapping("/signUp")
   public String signUpPost(@ModelAttribute UserList userList) {
      //회원가입 실행시 form에 입력한 정보를 기반으로 유저리스트에 저장한다
      userListRepository.save(userList);
      return "redirect:/login";
   }
   
}
