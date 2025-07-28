package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("MS1")
public interface FeignClienC {
  @GetMapping("/search/show")	
  public String fget();
}
