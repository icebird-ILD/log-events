package com.example.events.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	private String id;

	private String type = "N/A";
	private String host = "N/A";

	private boolean alert;

	private String duration;

	public Event() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", type=" + type + ", host=" + host + ", alert=" + alert + ", duration=" + duration
				+ "]";
	}
	
	

}
