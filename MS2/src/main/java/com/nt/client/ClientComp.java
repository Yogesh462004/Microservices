package com.nt.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientComp {
	@Autowired
  private LoadBalancerClient c;
  
  public String getall() {
	  ServiceInstance is=c.choose("MS1");
	  URI uri=is.getUri();
	  String url=uri.toString()+"/search/show";
	  RestTemplate t=new RestTemplate();
	  ResponseEntity<String> res=t.getForEntity(url, String.class);
	  return res.getBody();
  }
}
