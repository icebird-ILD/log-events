package com.example.events.bean;

import java.util.Objects;

public class FlaggedEvent implements DataTransferObject {

	private String id;
	private String duration;

	public FlaggedEvent() {

	}

	public FlaggedEvent(String id, String duration) {
		super();
		this.id = id;
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlaggedEvent other = (FlaggedEvent) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "FlaggedEvent [id=" + id + ", duration=" + duration + "]";
	}

}
