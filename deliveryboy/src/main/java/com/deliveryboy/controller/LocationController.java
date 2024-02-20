package com.deliveryboy.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private KafkaService kafkaService;
	
	private Logger logger=LoggerFactory.getLogger(KafkaService.class);
	
	@PostMapping("/update")
	public ResponseEntity<?>updateLocation(){
		this.kafkaService.updateLocation("("+Math.round(Math.random()*100)+ ","+Math.round(Math.random()*100)+" "+")");
		logger.info("Updated");
		return new ResponseEntity<>(Map.of("message","Location Updated"),HttpStatus.OK);
	}
	

}
