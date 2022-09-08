package com.springbook.dto;

import java.sql.Timestamp;
import java.util.Date;

public class HealthDTO {

	private String status;
	private Timestamp timeStamp;
	
	public HealthDTO()
	{
		this.setStatus("Running!");
		this.setTimeStamp(new Timestamp(System.currentTimeMillis()));
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp time) {
		this.timeStamp = time;
	}
	
	
}
