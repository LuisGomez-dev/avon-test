package com.avon.sms.dto;

public class SMSRespuesta {
    private boolean success;
    private Integer code;
    private String id;
    
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SMSRespuesta() {
		super();
	}
    
    
}
