package com.avon.sms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.avon.sms.data.SMSStore;
import com.avon.sms.data.SMSStoreRepository;
import com.avon.sms.dto.SMSRespuesta;




@Service 
public class SMSServiceImpl implements SMSService {
	@Autowired
	SMSStoreRepository smsStoreRepository;
	
	public Map<String, Object> SMSProcess() {
		
		
		//Start Send Data		
		SMSStore smsStore = new SMSStore();
		smsStore.setNumber("525529490552");
		smsStore.setMessage("Mi mensaje de Texto del EXAMEN AVON (Luis Gomez)");
		SMSCallWS(smsStore);
		//Start Save Data
		smsStoreRepository.save(smsStore);

		//Start Send Data		
		smsStore = new SMSStore();
		smsStore.setNumber("525539937005");
		smsStore.setMessage("Mi mensaje de Texto del EXAMEN AVON (Luis Gomez)");
		SMSCallWS(smsStore);
		//Start Save Data
		smsStoreRepository.save(smsStore);
		
		//Start Send Data		
		smsStore = new SMSStore();
		smsStore.setNumber("525543688711");
		smsStore.setMessage("Mi mensaje de Texto del EXAMEN AVON (Luis Gomez)");
		SMSCallWS(smsStore);
		//Start Save Data
		smsStoreRepository.save(smsStore);
		
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("result", "Finalizado");
		return responseData;
	}

	private void SMSCallWS(SMSStore smsStore) {
		
		String strUsername = "D964FCED0741B7998B1DBD8327B27397";
		String strpassword="D38E7DC8828F983FEDA57E944130DEA4"; 
		String strnumber=smsStore.getNumber() ;
		String strmessage=smsStore.getMessage();

		
		
		String strUrl = String.format("http://api.c3ntrosms.com:8181/?username=%s&password=%s&number=%s&message=%s", strUsername,strpassword,strnumber,strmessage); 
		
		WebClient webClient = 
		WebClient.builder()
        .baseUrl(strUrl)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .build();
		
		SMSRespuesta smsRespuesta = webClient.get().retrieve().bodyToMono(SMSRespuesta.class).block();
		
		smsStore.setCode( smsRespuesta.getCode() );
		smsStore.setResultId(smsRespuesta.getId());
		smsStore.setSuccess(smsRespuesta.isSuccess() );
		
		return;
	}

	
	public Map<String, Object> listSMS() {
		Map<String, Object> responseData = new HashMap<>();
		List<SMSStore> msmData = smsStoreRepository.findAll();

		responseData.put("result", msmData);
		return  responseData;
	}
	
}
