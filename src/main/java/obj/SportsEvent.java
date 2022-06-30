package obj;

import javax.persistence.*;

@Entity
@Table(name = "SPORTEVENTS")

public class SportsEvent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventID;

	@Column(name = "events_name")
	private String eventName;
	
	@Column(name = "events_date")
	private String eventDate;
	
	@Column(name = "events_capacity")
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
