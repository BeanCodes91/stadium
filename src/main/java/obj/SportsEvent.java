package obj;

import javax.persistence.*;

@Entity
@Table

public class SportsEvent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventID;

	@Column
	private String eventName;
	
	@Column
	private String eventDate;
	
	@Column
	private int eventCap;
	
	public SportsEvent() {
		this.eventCap = 0;
	}

	public SportsEvent(String eventName, String eventDate) {
		this();
		this.eventName = eventName;
		this.eventDate = eventDate;
	}

	public int getEventID() {
		return eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventCap() {
		return eventCap;
	}

	public void setEventCap(int eventCap) {
		this.eventCap = eventCap;
	}
	
	
}
