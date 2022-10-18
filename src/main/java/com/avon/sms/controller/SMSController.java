package com.avon.sms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avon.sms.service.SMSServiceImpl;
@RestController
public class SMSController {
	@Autowired
	SMSServiceImpl smsService;
		
	@GetMapping(value = "envio")
	Map<String, Object>   envio(){
		return  smsService.SMSProcess();
	}
	
	@GetMapping(value = "consulta")
	Map<String, Object>  listado(){
		return smsService.listSMS() ; 
	}
	
}
