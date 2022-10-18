package com.avon.sms.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity(name = "legsstore")
@Table(name = "legsstore")
public class SMSStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_STORE")
    private Long Id;
    
    @Column(name="RESULT")
    private boolean success;
    
    @Column(name="CODE")
    private Integer code;
    
    @Column(name="IDRESULT")
    private String resultId;

    @Column(name="MESSAGE")
    private String message;

    @Column(name="NUMBER")
    private String number;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

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

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public SMSStore() {
		super();
	}
    
    
    
    
}
