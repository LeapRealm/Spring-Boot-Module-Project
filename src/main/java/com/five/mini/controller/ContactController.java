package com.five.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.five.mini.email.Mailer;
import com.five.mini.email.SMTPAuthenticator;

@Controller
public class ContactController {

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@PostMapping("/contact")
	@ResponseBody
	public String contactPost(String email, String comment) {
		Mailer mailer = new Mailer();
		mailer.sendMail("fbaa4412@naver.com", "문의내용 : " + email, comment, new SMTPAuthenticator());
		return "ok";
	}
}