package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class MSC {
   @GetMapping("/show")
   public String show() {
	   return "Hi Yogesh";
   }
}
