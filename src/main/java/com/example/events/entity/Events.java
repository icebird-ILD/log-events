package com.example.events.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.events.bean.DataTransferObject;

@Entity
@Table(name = "events")
@IdClass(EventID.class)
public class Events implements Comparable<Events>, DataTransferObject {

	@Id
	private String id;

	@Id
	private String state;

	private String type;
	private String host;

	private boolean alert;

	private java.sql.Timestamp timestamp;

	public Events() {

	}

	public Events(String id, String state, String type, String host, Timestamp timestamp) {
		super();
		this.id = id;
		this.state = state;
		this.type = type;
		this.host = host;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Events other = (Events) obj;
		return Objects.equals(id, other.id) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "[" + id + " : " + state + " : " + timestamp + "]";
	}

	@Override
	public int compareTo(Events o) {
		// TODO Auto-generated method stub
		return this.getTimestamp().compareTo(o.getTimestamp());
	}

}
