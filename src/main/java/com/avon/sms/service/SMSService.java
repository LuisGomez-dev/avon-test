package com.avon.sms.service;

import java.util.Map;

public interface SMSService {
	public Map<String, Object>  SMSProcess();
	public Map<String, Object> listSMS();
}
